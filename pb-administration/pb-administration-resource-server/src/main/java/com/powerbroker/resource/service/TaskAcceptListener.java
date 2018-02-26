package com.powerbroker.resource.service;

import com.powerbroker.common.utils.StringUtil;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.RewardDAO;
import com.powerbroker.resource.entity.Reward;
import com.powerbroker.resource.entity.Staff;
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
public class TaskAcceptListener implements TaskListener {

    private static final long serialVersionUID = -9221016849097174018L;

    @Resource
    private RewardDAO rewardDAO;

    @Transactional
    public void notify(DelegateTask delegateTask) {

        String businessKey = delegateTask.getExecution().getProcessBusinessKey();

        String activityId = delegateTask.getExecution().getCurrentActivityId();

        Long rewardId = ValueUtil.idDecode(businessKey);

        Reward reward = rewardDAO.findOne(rewardId);

        if (null != reward && StringUtil.hasText(activityId)) {

            if (activityId.equalsIgnoreCase("accept")) {
                Staff staff = new Staff();
                staff.setId(Long.valueOf(delegateTask.getAssignee()));
                reward.setStaff(staff);
                reward.setTaskState(TaskService.TASK_STATE_ACCEPTED);
                reward.setAcceptedAt(LocalDateTime.now());
            } else if (activityId.equalsIgnoreCase("assign")) {
                Staff assigner = new Staff();
                String assignerId = delegateTask.getExecution().getVariable("assigner", String.class);
                assigner.setId(Long.valueOf(assignerId));
                Staff staff = new Staff();
                staff.setId(Long.valueOf(delegateTask.getAssignee()));
                reward.setAssigner(assigner);
                reward.setAssigned(Boolean.TRUE);
                reward.setStaff(staff);
                reward.setTaskState(TaskService.TASK_STATE_ASSIGNED);
                reward.setAcceptedAt(LocalDateTime.now());
            } else {
                reward.setTaskState(TaskService.TASK_STATE_UNKNOWN);
            }

            rewardDAO.save(reward);
        }
    }
}
