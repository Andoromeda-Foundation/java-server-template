package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexConfigurationDTO;
import com.powerbroker.resource.service.IndexConfigurationService;
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
@RequestMapping(value = "/indexConfiguration")
public class IndexConfigurationController {

    @Resource
    private IndexConfigurationService indexConfigurationService;

    @PostMapping(value = "/realTime")
    public GenericResponse<List<IndexConfigurationDTO>> realTime(@RequestBody @Valid IndexConfigurationDTO request,
                                                                 BindingResult bindingResult) throws Exception {
        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexConfigurationDTO>> response) -> {

            response.setData(indexConfigurationService.realTime(request));
            response.setResult(true);
        });
    }
}