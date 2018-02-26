package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexElectricityDTO;
import com.powerbroker.resource.service.IndexElectricityService;
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
@RequestMapping(value = "/indexElectricity")
public class IndexElectricityController {

    @Resource
    private IndexElectricityService indexElectricityService;

    @PostMapping(value = "/history")
    public GenericResponse<List<IndexElectricityDTO>> history(@RequestBody @Valid IndexElectricityDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexElectricityDTO>> response) -> {

            response.setData(indexElectricityService.history(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/historyByMonth")
    public GenericResponse<List<IndexElectricityDTO>> historyByMonth(@RequestBody @Valid IndexElectricityDTO request,
                                                                     BindingResult bindingResult) throws Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexElectricityDTO>> response) -> {

            response.setData(indexElectricityService.historyByMonth(request));
            response.setResult(true);
        });
    }

}