package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexVoltageDTO;
import com.powerbroker.resource.service.IndexVoltageService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/indexVoltage")
public class IndexVoltageController {

    @Resource
    private IndexVoltageService indexVoltageService;

    @PostMapping(value = "/find")
    public GenericResponse<IndexVoltageDTO> retrieve(@RequestBody @Valid IndexVoltageDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<IndexVoltageDTO> response) -> {

            response.setData(indexVoltageService.aggregate(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/realTime")
    public GenericResponse<List<IndexVoltageDTO>> realTime(@RequestBody @Valid IndexVoltageDTO request,
                                                           BindingResult bindingResult) throws Exception {
        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexVoltageDTO>> response) -> {

            response.setData(indexVoltageService.realTime(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/history")
    public GenericResponse<List<IndexVoltageDTO>> history(@RequestBody @Valid IndexVoltageDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexVoltageDTO>> response) -> {

            response.setData(indexVoltageService.history(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/historyMaxByDay")
    public GenericResponse<List<IndexVoltageDTO>> historyMaxByDay(@RequestBody @Valid IndexVoltageDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexVoltageDTO>> response) -> {

            response.setData(indexVoltageService.historyMaxByDay(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/historyMinByDay")
    public GenericResponse<List<IndexVoltageDTO>> historyMinByDay(@RequestBody @Valid IndexVoltageDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexVoltageDTO>> response) -> {

            response.setData(indexVoltageService.historyMinByDay(request));
            response.setResult(true);
        });
    }

}