package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.RewardDTO;
import com.powerbroker.resource.model.RewardStateDTO;
import com.powerbroker.resource.service.RewardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wjwjtftf
 * Created on 2017/1/18.
 */
@RestController
@RequestMapping(value = "/reward")
public class RewardController extends AbstractCRUDHandler<Long, RewardDTO, RewardService> {

    @GetMapping(value = "/mine/{pageNum}")
    public GenericResponse<List<RewardDTO>> mine(@PathVariable(value = "pageNum") Integer num) throws Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = getService().mine(getPageRequest(num, null));
            extractResponse(response, data);
        });
    }

    @GetMapping(value = "/listByTimeLine/{pageNum}")
    public GenericResponse<List<RewardDTO>> listByTimeLine(@PathVariable(value = "pageNum") Integer pageNum) throws
            Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = timeLineData(pageNum, null);

            extractResponse(response, data);
        });
    }

    @GetMapping(value = "/listByTimeLine/{pageNum}/{pageSize}")
    public GenericResponse<List<RewardDTO>> listByTimeLine(@PathVariable(value = "pageNum") Integer pageNum,
                                                           @PathVariable(value = "pageSize") Integer pageSize) throws
            Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = timeLineData(pageNum, pageSize);

            extractResponse(response, data);
        });
    }

    private Page timeLineData(Integer pageNum, Integer pageSize) {
        return ((PageableService) getService()).listActive(getPageRequest(pageNum, pageSize));
    }

    @GetMapping(value = "/listByPriority/{pageNum}")
    public GenericResponse<List<RewardDTO>> listByPriority(@PathVariable(value = "pageNum") Integer pageNum) throws
            Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = priorityData(pageNum, null);

            extractResponse(response, data);
        });
    }

    @GetMapping(value = "/listByPriority/{pageNum}/{pageSize}")
    public GenericResponse<List<RewardDTO>> listByPriority(@PathVariable(value = "pageNum") Integer pageNum,
                                                           @PathVariable(value = "pageSize") Integer pageSize) throws
            Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = priorityData(pageNum, pageSize);

            extractResponse(response, data);
        });
    }

    private Page priorityData(Integer pageNum, Integer pageSize) {
        return ((PageableService) getService()).listActive(getPageRequest(pageNum, pageSize,
                new Sort(Sort.Direction.DESC, "priority")));
    }

    /**
     * 个人待办任务分页查询1
     */
    @GetMapping("/todo/{pageNum}/{pageSize}")
    public GenericResponse<List<RewardDTO>> todoList(@PathVariable(value = "pageNum") Integer pageNum,
                                                     @PathVariable(value = "pageSize") Integer pageSize) throws Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = getService()
                    .findTodoTasks(new PageRequest(setAndGetPageNumber(pageNum), setAndGetPageSize(pageSize)));

            extractResponse(response, data);
        });
    }

    /**
     * 个人待办任务分页查询2
     */
    @GetMapping("/todo/{pageNum}")
    public GenericResponse<List<RewardDTO>> todoList(@PathVariable(value = "pageNum") Integer pageNum)
            throws Exception {

        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = getService().findTodoTasks(new PageRequest(setAndGetPageNumber(pageNum),
                    setAndGetPageSize(null)));

            extractResponse(response, data);
        });
    }

    /**
     * 悬赏任务列表
     */
    @GetMapping("/competeList/{pageNum}")
    public GenericResponse<List<RewardDTO>> competeList(@PathVariable(value = "pageNum") Integer pageNum)
            throws Exception {
        return ControllerTemplate.call((GenericResponse<List<RewardDTO>> response) -> {

            Page<RewardDTO> data = getService().findCompeteTasks(new PageRequest(setAndGetPageNumber(pageNum),
                    setAndGetPageSize(null)));

            extractResponse(response, data);
        });
    }

    @GetMapping("/state")
    public GenericResponse<RewardStateDTO> state() throws Exception {

        return ControllerTemplate.call((GenericResponse<RewardStateDTO> response) -> {
            response.setData(getService().state());
            response.setResult(true);
        });
    }

    @Override
    protected Sort getSort() {
        return new Sort(Sort.Direction.DESC, "createAt");
    }
}
