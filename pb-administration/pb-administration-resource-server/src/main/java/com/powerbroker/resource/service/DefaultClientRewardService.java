package com.powerbroker.resource.service;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.DateTimeUtil;
import com.powerbroker.common.utils.StringUtil;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.ClientDAO;
import com.powerbroker.resource.dao.RewardDAO;
import com.powerbroker.resource.dao.UserDAO;
import com.powerbroker.resource.entity.Client;
import com.powerbroker.resource.entity.Reward;
import com.powerbroker.resource.entity.User;
import com.powerbroker.resource.model.RewardDTO;
import com.powerbroker.resource.model.RewardStateDTO;
import com.powerbroker.resource.model.TaskDTO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.data.domain.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wjwjtftf
 * Created on 2017/1/18.
 */
@Slf4j
@Service
@Transactional
public class DefaultClientRewardService extends AbstractJPAService<Long, RewardDTO, Reward, RewardDAO>
        implements RewardService {

    @Resource
    @Setter
    private RewardDAO rewardDAO;

    @Resource
    @Setter
    private UserDAO userDAO;

    @Resource
    @Setter
    private ClientDAO clientDAO;

    @Resource
    @Setter
    private IdentityService identityService;

    @Resource
    @Setter
    private RuntimeService runtimeService;

    @Resource
    @Setter
    private TaskService taskService;

    public DefaultClientRewardService() {
        super();
        allowingDelAll = true;
    }

    @Override
    public RewardDTO create(RewardDTO rewardDTO) {

        Long clientId = getCurrentAuthUserId();

        Client client = clientDAO.findOne(clientId);

        identityService.setAuthenticatedUserId(clientId.toString());

        try {
            String businessKey = rewardDTO.getId();

            Map<String, Object> variables = new HashMap<>();
            LocalDateTime now = LocalDateTime.now();
            variables.put("publishAt", now.toEpochSecond(ZoneOffset.UTC));
            variables.put("dueAt", DateTimeUtil.convert(now.plusDays(7)));
            variables.put("publishClientId", clientId);
            variables.put("powerStationId", client.getPowerStation().getId());
            variables.put("businessKey", businessKey);
            variables.put("taskPriority", rewardDTO.getPriority());

            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("reward", businessKey,
                    variables);

            String processInstanceId = processInstance.getId();

            log.info("@@@ start process of {key={}, bkey={}, pid={}, variables={}}", "reward", businessKey,
                    processInstanceId, variables);

            rewardDTO.setProcessInstanceId(processInstanceId);
        } finally {
            identityService.setAuthenticatedUserId(null);
        }

        return rewardDTO;
    }

    /**
     * 查询待办任务
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RewardDTO> findTodoTasks(Pageable pageable) {

        Long clientId = getCurrentAuthUserId();

        log.info("@@@ find todo task by assigne [{}]", clientId);

        long total = taskService.createTaskQuery().taskCandidateOrAssigned(clientId.toString()).count();

        List<RewardDTO> rewardDTOs = Collections.emptyList();

        if (total > 0) {

            // 根据当前人的ID查询
            List<Task> tasks = taskService.createTaskQuery().taskCandidateOrAssigned(clientId.toString())
                    .listPage(pageable.getOffset(), pageable.getPageSize());

            rewardDTOs = tasks.stream().map(this::convertRewardDTO).collect(Collectors.toList());
        }

        return new PageImpl<>(rewardDTOs, pageable, total);
    }

    @Transactional(readOnly = true)
    public RewardDTO retrieve(Long id) {

        Assert.notNull(id, "id should not be null");

        RewardDTO rewardDTO = super.retrieve(id);

        String processInstanceId = rewardDTO.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).active().singleResult();

        // TODO: should throw exception
        if (null == processInstance) {
            return null;
        }

        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();

        convertTasks(rewardDTO, tasks);

        return rewardDTO;
    }

    @Override
    public boolean delete(Long id) {

        super.delete(id);

        Long clientId = getCurrentAuthUserId();

        identityService.setAuthenticatedUserId(clientId.toString());

        try {
            RewardDTO rewardDTO = super.retrieve(id);

            String processInstanceId = rewardDTO.getProcessInstanceId();

            if (StringUtil.hasText(processInstanceId)) {
                long count = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).count();

                if (count > 0) {
                    runtimeService.deleteProcessInstance(processInstanceId, "no reason");
                }
            }
        } finally {
            identityService.setAuthenticatedUserId(null);
        }

        return true;
    }

    /**
     * @return 竞争任务任务列表
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RewardDTO> findCompeteTasks(Pageable pageable) {

        List<RewardDTO> rewardDTOS = Collections.emptyList();
        long total = 0;

        Long clientId = getCurrentAuthUserId();
        User user = userDAO.findOne(clientId);
        if (null != user && !CollectionUtils.isEmpty(user.getRoles())) {

            boolean isEngineer = user.getRoles().stream().anyMatch(r -> "BSS_USER".equals(r.getName()));

            if (isEngineer) {
                total = taskService.createTaskQuery().taskCandidateGroup("engineer").count();
                rewardDTOS = taskService.createTaskQuery().taskCandidateGroup("engineer")
                        .listPage(pageable.getOffset(), pageable.getPageSize()).stream().map(this::convertRewardDTO)
                        .filter(Objects::nonNull).collect(Collectors.toList());
            }
        }

        return new PageImpl<>(rewardDTOS, pageable, total);
    }

    @Override
    public RewardStateDTO state() {


        Long clientId = getCurrentAuthUserId();

        Client client = new Client();
        client.setId(clientId);

        Reward probe = new Reward();
        probe.setPublishClient(client);
        probe.setTaskState(com.powerbroker.resource.service.TaskService.TASK_STATE_PUBLISHED);

        Example<Reward> example = Example.of(probe);
        long todoTasksCount = dao.count(example);

        RewardStateDTO rewardStateDTO = new RewardStateDTO();
        rewardStateDTO.setTodoCount(todoTasksCount);

        probe.setTaskState(com.powerbroker.resource.service.TaskService.TASK_STATE_COMPLETED);
        probe.setHasComment(false);
        example = Example.of(probe);
        long uncommentCount = dao.count(example);

        rewardStateDTO.setUncommentCount(uncommentCount);

        return rewardStateDTO;
    }

    @Override
    public Page<RewardDTO> mine(Pageable pageable) {
        return null;
    }

    private void convertTasks(RewardDTO rewardDTO, List<Task> tasks) {
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(ValueUtil.idEncode(Long.valueOf(task.getId())));
            taskDTO.setName(task.getName());

            rewardDTO.getTask().add(taskDTO);
        }
    }

    private RewardDTO convertRewardDTO(Task task) {

        RewardDTO rewardDTO;
        String processInstanceId = task.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).active().singleResult();
        if (processInstance == null || null == processInstance.getBusinessKey()) {
            return null;
        }

        Long id;
        try {
            id = Long.parseLong(processInstance.getBusinessKey());
        } catch (NumberFormatException e) {
            id = ValueUtil.idDecode(processInstance.getBusinessKey());
        }

        Reward reward = rewardDAO.findOne(id);

        if (null != reward) {
            rewardDTO = ValueUtil.dump(reward, RewardDTO.class);
        } else {
            rewardDTO = new RewardDTO();
        }

        convertTasks(rewardDTO, Arrays.asList(task));

        return rewardDTO;
    }

    @Override
    public Page<RewardDTO> listActive(Pageable pageable) {

        log.info("@@@ find todo task by assigne [{}]", getCurrentAuthUserId());

        PBAuthUser authUser = getCurrentAuthUser();
        Long authUserId = getCurrentAuthUserId();

        TaskQuery taskQuery = taskService.createTaskQuery();
        Collection<GrantedAuthority> authorities = authUser.getAuthorities();
        boolean isAdmin = false;
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equalsIgnoreCase("ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        Client client = clientDAO.getOne(authUserId);


        if (isAdmin) {
            taskQuery = taskQuery.processVariableValueEquals("powerStationId", client.getPowerStation().getId());
        } else {
            taskQuery = taskQuery.processVariableValueEquals("publishClientId", client.getId());
        }

        Sort sort = pageable.getSort();
        if (null != sort) {
            if (null != sort.getOrderFor("createAt")) {
                taskQuery = taskQuery.orderByTaskCreateTime().desc();
            }

            if (null != sort.getOrderFor("taskPriority")) {
                taskQuery = taskQuery.orderByTaskPriority().desc();
            }
        }
        long total = taskQuery.count();

        List<RewardDTO> rewardDTOs = Collections.emptyList();

        if (total > 0) {
            List<Task> tasks = taskQuery.listPage(pageable.getOffset(), pageable.getPageSize());
            rewardDTOs = tasks.stream().map(this::convertRewardDTO).collect(Collectors.toList());
        }

        return new PageImpl<>(rewardDTOs, pageable, total);
    }
}
