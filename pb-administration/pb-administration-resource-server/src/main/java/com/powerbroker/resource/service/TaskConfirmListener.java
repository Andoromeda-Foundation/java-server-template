package com.powerbroker.resource.service;

import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.RewardDAO;
import com.powerbroker.resource.entity.Reward;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * @author wjwjtftf
 *         Created on 2017/6/15.
 */
@Component
public class TaskConfirmListener implements TaskListener {

    @Resource
    private RewardDAO rewardDAO;

    @Transactional
    public void notify(DelegateTask delegateTask) {

        String businessKey = delegateTask.getExecution().getProcessBusinessKey();

        Long rewardId = ValueUtil.idDecode(businessKey);

        Reward reward = rewardDAO.findOne(rewardId);

        if (null != reward) {
            reward.setTaskState(TaskService.TASK_STATE_CONFIRM);
            reward.setConfirmedAt(LocalDateTime.now());
            rewardDAO.save(reward);
        }
    }
}
