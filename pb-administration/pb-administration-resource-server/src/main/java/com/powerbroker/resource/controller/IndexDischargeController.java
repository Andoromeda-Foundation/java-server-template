package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexDischargeDTO;
import com.powerbroker.resource.service.IndexDischargeService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/indexDischarge")
public class IndexDischargeController {

    @Resource
    private IndexDischargeService indexDischargeService;

    @PostMapping(value = "/realTime")
    public GenericResponse<List<IndexDischargeDTO>> realTime(@RequestBody @Valid IndexDischargeDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexDischargeDTO>> response) -> {

            response.setData(indexDischargeService.realTime(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/realTimeHistory")
    public GenericResponse<List<IndexDischargeDTO>> realTimeHistory(@RequestBody @Valid IndexDischargeDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexDischargeDTO>> response) -> {

            response.setData(indexDischargeService.realTimeHistory(request));
            response.setResult(true);
        });
    }


    @PostMapping(value = "/deviceList")
    public GenericResponse<Set<Object>> deviceList(@RequestBody @Valid IndexDischargeDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<Set<Object>> response) -> {

            response.setData(indexDischargeService.deviceList(request));
            response.setResult(true);
        });
    }
}