package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.CommentDAO;
import com.powerbroker.resource.dao.RewardDAO;
import com.powerbroker.resource.entity.Comment;
import com.powerbroker.resource.entity.Reward;
import com.powerbroker.resource.model.CommentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultCommentService extends AbstractJPAService<Long, CommentDTO, Comment, CommentDAO> implements CommentService {

    @Resource
    private RewardDAO rewardDAO;

    @Override
    protected void createHandler(Comment target) {
        if (target.getReward().getTaskState() < TaskService.TASK_STATE_COMPLETED) {
            throw new IllegalArgumentException("task not finished");
        }

        if (target.getReward().getHasComment()) {
            throw new IllegalArgumentException("task already commented");
        }

        super.createHandler(target);
    }

    @Override
    protected void afterCreateHandler(Comment target) {
        Reward reward = target.getReward();
        reward.setHasComment(true);
        rewardDAO.save(reward);
    }

    @Override
    protected void updateHandler(Comment target) {
        if (target.getReward().getTaskState() < TaskService.TASK_STATE_COMPLETED) {
            throw new IllegalArgumentException("update method not support in comment");
        }
    }
}
