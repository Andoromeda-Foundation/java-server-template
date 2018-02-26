/**
 * For Business Activities.
 * <p>
 * Copyright 2016 zhongxin, BSS Team. All rights reserved.
 * May not be used without authorization.
 * <p>
 * Create At 2016年8月24日
 */
package com.powerbroker.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

import java.util.concurrent.Callable;

/**
 * @author william
 */
@Slf4j
public class ControllerTemplate {

    public static <RQ, RS> Callable<GenericResponse<RS>> spawnAction(ControllerCallback<RS> callback) {
        return spawnAction(null, callback);
    }

    public static <RQ, RS> Callable<GenericResponse<RS>> spawnAction(BindingResult bindingResult,
                                                                     ControllerCallback<RS> callback) {
        return new Callable<GenericResponse<RS>>() {

            @Override
            public GenericResponse<RS> call() throws Exception {

                return ControllerTemplate.call(bindingResult, callback);
            }
        };
    }

    public static <RQ, RS> GenericResponse<RS> call(ControllerCallback<RS> callback) throws Exception {
        return ControllerTemplate.call(null, callback);
    }

    public static <RQ, RS> GenericResponse<RS> call(BindingResult bindingResult, ControllerCallback<RS> callback)
            throws Exception {

        GenericResponse<RS> response = new GenericResponse<RS>();

        if (null != bindingResult) {

            log.debug("@@@ PROC: action with validator @@@");

            boolean result = validate(bindingResult, response);

            if (result && null != callback) {
                execute(callback, response);
            }
        } else {
            log.debug("@@@ PROC: action without validator @@@");

            if (null != callback) {
                execute(callback, response);
            }
        }

        return response;
    }

    private static <RS> void execute(ControllerCallback<RS> callback, GenericResponse<RS> response) {
        try {
            callback.execute(response);
        } catch (Exception e) {
            log.error("{}", e);
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage(e.getLocalizedMessage());
            response.setError(errorDTO);
        }
    }

    protected static <RS> boolean validate(BindingResult bindingResult, GenericResponse<RS> response) {

        boolean result = !bindingResult.hasErrors();

        if (!result) {
            response.setResult(false);
            response.getError().setCode("VALIDATE_ERROR");
            response.getError().setMessage(bindingResult.getAllErrors().toString());
        }

        return result;
    }
}
