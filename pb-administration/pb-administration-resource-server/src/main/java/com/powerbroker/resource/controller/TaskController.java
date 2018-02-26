package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.model.TaskDTO;
import com.powerbroker.resource.service.TaskService;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wjwjtftf
 *         Created on 2017/1/18.
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController extends AbstractCRUDHandler<Long, TaskDTO, TaskService> {

    @PutMapping("/accept/{id}")
    public GenericResponse<String> accept(@PathVariable("id") String id) throws Exception {

        Assert.notNull(id, "task id should not be null");

        return ControllerTemplate.call((GenericResponse<String> response) -> {
            getService().accept(ValueUtil.idDecode(id));
            response.setData("领取");
            response.setResult(true);
        });
    }

    @PutMapping("/assign/{id}")
    public GenericResponse<String> assign(@PathVariable("id") String id, @RequestBody @Valid TaskDTO request,
                                          BindingResult bindingResult) throws Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<String> response) -> {
            getService().assign(ValueUtil.idDecode(id), ValueUtil.idDecode(request.getStaffId()));
            response.setData("指派");
            response.setResult(true);
        });
    }

    @PutMapping("/depart/{id}")
    public GenericResponse<String> depart(@PathVariable("id") String id) throws Exception {

        return ControllerTemplate.call((GenericResponse<String> response) -> {
            getService().depart(ValueUtil.idDecode(id));
            response.setData("出发");
            response.setResult(true);
        });
    }

    @PutMapping("/execute/{id}")
    public GenericResponse<String> execute(@PathVariable("id") String id) throws Exception {

        return ControllerTemplate.call((GenericResponse<String> response) -> {
            getService().execute(ValueUtil.idDecode(id));
            response.setData("执行");
            response.setResult(true);
        });
    }

    @PutMapping("/complete/{id}")
    public GenericResponse<String> complete(@PathVariable("id") String id) throws Exception {

        Assert.notNull(id, "task id should not be null");

        return ControllerTemplate.call((GenericResponse<String> response) -> {
            getService().complete(ValueUtil.idDecode(id));
            response.setData("完成");
            response.setResult(true);
        });
    }

    @PutMapping("/confirm/{id}")
    public GenericResponse<String> confirm(@PathVariable("id") String id) throws Exception {

        Assert.notNull(id, "task id should not be null");

        return ControllerTemplate.call((GenericResponse<String> response) -> {
            getService().confirm(ValueUtil.idDecode(id));
            response.setData("确认");
            response.setResult(true);
        });
    }
}
