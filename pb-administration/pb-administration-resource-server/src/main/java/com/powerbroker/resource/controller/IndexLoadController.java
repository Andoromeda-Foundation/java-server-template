package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexLoadDTO;
import com.powerbroker.resource.service.IndexLoadService;
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
@RequestMapping(value = "/indexLoad")
public class IndexLoadController {

    @Resource
    private IndexLoadService indexLoadService;

    @PostMapping(value = "/find")
    public GenericResponse<IndexLoadDTO> find(@RequestBody @Valid IndexLoadDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<IndexLoadDTO> response) -> {

            response.setData(indexLoadService.aggregate(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/history")
    public GenericResponse<List<IndexLoadDTO>> history(@RequestBody @Valid IndexLoadDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexLoadDTO>> response) -> {

            response.setData(indexLoadService.history(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/realTime")
    public GenericResponse<List<IndexLoadDTO>> realTime(@RequestBody @Valid IndexLoadDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexLoadDTO>> response) -> {

            response.setData(indexLoadService.realTime(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/realTimeHistory")
    public GenericResponse<List<IndexLoadDTO>> realTimeHistory(@RequestBody @Valid IndexLoadDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexLoadDTO>> response) -> {

            response.setData(indexLoadService.realTimeHistory(request));
            response.setResult(true);
        });
    }
}