package com.powerbroker.resource.service;

import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.RewardDTO;
import com.powerbroker.resource.model.RewardStateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by wjwjtftf on 2017/1/18.
 */
public interface RewardService extends PageableService<Long, RewardDTO> {

    Page<RewardDTO> findTodoTasks(Pageable pageable);

    Page<RewardDTO> findCompeteTasks(Pageable pageable);

    RewardStateDTO state();

    Page<RewardDTO> mine(Pageable pageable);
}
