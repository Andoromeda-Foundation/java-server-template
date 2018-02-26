package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.IndexPowerAnalysisDTO;
import com.powerbroker.resource.model.IndexPowerDTO;
import com.powerbroker.resource.service.IndexPowerAnalysisService;
import com.powerbroker.resource.service.IndexPowerService;
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
@RequestMapping(value = "/indexPower")
public class IndexPowerController {

    @Resource
    private IndexPowerService indexPowerService;

    @Resource
    private IndexPowerAnalysisService indexPowerAnalysisService ;

    @PostMapping(value = "/find")
    public GenericResponse<IndexPowerDTO> retrieve(@RequestBody @Valid IndexPowerDTO request, BindingResult bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<IndexPowerDTO> response) -> {

            response.setData(indexPowerService.aggregate(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/realTime")
    public GenericResponse<List<IndexPowerDTO>> realTime(@RequestBody @Valid IndexPowerDTO request,
                                                         BindingResult bindingResult) throws Exception {
        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexPowerDTO>> response) -> {

            response.setData(indexPowerService.realTime(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/history")
    public GenericResponse<List<IndexPowerDTO>> history(@RequestBody @Valid IndexPowerDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexPowerDTO>> response) -> {

            response.setData(indexPowerService.history(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/historyByDay")
    public GenericResponse<List<IndexPowerDTO>> historyByDay(@RequestBody @Valid IndexPowerDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexPowerDTO>> response) -> {

            response.setData(indexPowerService.historyByDay(request));
            response.setResult(true);
        });
    }

    @PostMapping(value = "/analysisByDay")
    public GenericResponse<List<IndexPowerAnalysisDTO>> analysisByDay(@RequestBody @Valid IndexPowerAnalysisDTO request, BindingResult
            bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<List<IndexPowerAnalysisDTO>> response) -> {

            response.setData(indexPowerAnalysisService.historyByDay(request));
            response.setResult(true);
        });
    }
}