package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexCurrentDTO;
import com.powerbroker.resource.service.IndexCurrentService;
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
@RequestMapping(value = "/indexCurrent")
public class IndexCurrentController {

    @Resource
    private IndexCurrentService indexCurrentService;

    @PostMapping(value = "/find")
    public GenericResponse<IndexCurrentDTO> retrieve(@RequestBody @Valid IndexCurrentDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<IndexCurrentDTO> response) -> {

            response.setData(indexCurrentService.aggregate(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/realTime")
    public GenericResponse<List<IndexCurrentDTO>> realTime(@RequestBody @Valid IndexCurrentDTO request,
                                                           BindingResult bindingResult) throws Exception {
        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexCurrentDTO>> response) -> {

            response.setData(indexCurrentService.realTime(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/history")
    public GenericResponse<List<IndexCurrentDTO>> history(@RequestBody @Valid IndexCurrentDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexCurrentDTO>> response) -> {

            response.setData(indexCurrentService.history(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/historyMaxByDay")
    public GenericResponse<List<IndexCurrentDTO>> historyMaxByDay(@RequestBody @Valid IndexCurrentDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexCurrentDTO>> response) -> {

            response.setData(indexCurrentService.historyMaxByDay(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/historyMinByDay")
    public GenericResponse<List<IndexCurrentDTO>> historyMinByDay(@RequestBody @Valid IndexCurrentDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexCurrentDTO>> response) -> {

            response.setData(indexCurrentService.historyMinByDay(request));
            response.setResult(true);
        });
    }
}