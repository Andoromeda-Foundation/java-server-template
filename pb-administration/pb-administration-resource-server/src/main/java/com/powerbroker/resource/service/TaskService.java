package com.powerbroker.resource.service;

import com.powerbroker.common.service.CRUDService;
import com.powerbroker.resource.model.TaskDTO;

/**
 * Created by wjwjtftf on 2017/1/18.
 */
public interface TaskService extends CRUDService<Long, TaskDTO> {

    int TASK_STATE_UNKNOWN = -1;
    int TASK_STATE_PUBLISHED = 10;
    int TASK_STATE_ACCEPTED = 20;
    int TASK_STATE_ASSIGNED = 30;
    int TASK_STATE_DEPARTED = 40;
    int TASK_STATE_EXECUTED = 50;
    int TASK_STATE_COMPLETED = 60;
    int TASK_STATE_CONFIRM = 100;

    void accept(Long id);

    void assign(Long id, Long staffId);

    void depart(Long id);

    void execute(Long id);

    void complete(Long id);

    void confirm(Long id);
}
