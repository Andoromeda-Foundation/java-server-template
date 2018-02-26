package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexMdDTO;
import com.powerbroker.resource.service.IndexMdService;
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
@RequestMapping(value = "/indexMd")
public class IndexMdController {

    @Resource
    private IndexMdService indexMdService;

    @PostMapping(value = "/find")
    public GenericResponse<IndexMdDTO> retrieve(@RequestBody @Valid IndexMdDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<IndexMdDTO> response) -> {

            response.setData(indexMdService.aggregate(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/history")
    public GenericResponse<List<IndexMdDTO>> history(@RequestBody @Valid IndexMdDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexMdDTO>> response) -> {

            response.setData(indexMdService.history(request));
            response.setResult(true);
        });
    }

}