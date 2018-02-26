package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.Constants;
import com.powerbroker.resource.dao.ClientDAO;
import com.powerbroker.resource.dao.RewardDAO;
import com.powerbroker.resource.dao.UserDAO;
import com.powerbroker.resource.entity.Client;
import com.powerbroker.resource.entity.Reward;
import com.powerbroker.resource.entity.User;
import com.powerbroker.resource.model.RewardDTO;
import com.powerbroker.resource.model.RewardStateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wjwjtftf on 2017/1/18.
 */
@Service
@Transactional
public class DefaultRewardService extends AbstractJPAService<Long, RewardDTO, Reward, RewardDAO> implements
        RewardService {

    @Resource(name = "defaultClientRewardService")
    private RewardService defaultClientRewardService;

    @Resource(name = "defaultUserRewardService")
    private RewardService defaultUserRewardService;

    @Resource
    private ClientDAO clientDAO;

    @Resource
    private UserDAO userDAO;

    private RewardService getProxyService() {

        Integer authType = getAuthType();

        if (Constants.USER_AUTH_TYPE == authType) {
            return defaultUserRewardService;
        } else if (Constants.CLIENT_USER_TYPE == authType) {
            return defaultClientRewardService;
        }

        return this;
    }

    @Override
    protected void createHandler(Reward target) {
        super.createHandler(target);

        Client publishClient = target.getPublishClient();
        if (null != publishClient) {
            Client client = clientDAO.findOne(publishClient.getId());
            target.setPublishClient(client);
            target.setPowerStation(client.getPowerStation());
        }

        User user = userDAO.findOne(getCurrentAuthUserId());
        target.setPublishUser(user);

        target.setHasComment(false);
        target.setHasData(false);
        target.setTaskState(com.powerbroker.resource.service.TaskService.TASK_STATE_PUBLISHED);
    }

    @Override
    public RewardDTO create(RewardDTO dto) {
        dto = super.create(dto);
        dto = getProxyService().create(dto);
        this.update(dto);
        return dto;
    }

    @Override
    public RewardDTO retrieve(Long id) {
        return getProxyService().retrieve(id);
    }

    @Override
    public boolean delete(Long id) {
        return getProxyService().delete(id);
    }

    @Override
    public void deleteAll() {
        getProxyService().deleteAll();
    }

    @Override
    public Page<RewardDTO> findTodoTasks(Pageable pageable) {
        return getProxyService().findTodoTasks(pageable);
    }

    @Override
    public Page<RewardDTO> findCompeteTasks(Pageable pageable) {
        return getProxyService().findCompeteTasks(pageable);
    }

    @Override
    public RewardStateDTO state() {
        return getProxyService().state();
    }

    @Override
    public Page<RewardDTO> mine(Pageable pageable) {
        return getProxyService().mine(pageable);
    }

    @Override
    public Page<RewardDTO> listActive(Pageable pageable) {
        return getProxyService().listActive(pageable);
    }
}
