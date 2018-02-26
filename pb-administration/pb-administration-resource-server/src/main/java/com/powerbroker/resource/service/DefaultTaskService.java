package com.powerbroker.resource.service;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.service.AbstractService;
import com.powerbroker.resource.dao.StaffDAO;
import com.powerbroker.resource.dao.UserDAO;
import com.powerbroker.resource.entity.Staff;
import com.powerbroker.resource.entity.User;
import com.powerbroker.resource.model.TaskDTO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjwjtftf on 2017/1/18.
 */
@Slf4j
@Service
@Transactional
public class DefaultTaskService extends AbstractService<Long, TaskDTO> implements
        TaskService {

    @Setter
    @Resource
    private UserDAO userDAO;

    @Setter
    @Resource
    private StaffDAO staffDAO;

    @Setter
    @Resource
    private org.activiti.engine.TaskService taskService;

    @Setter
    @Resource
    private RuntimeService runtimeService;

    protected PBAuthUser getCurrentAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PBAuthUser authUser = null;
        if (null != authentication) {
            authUser = (PBAuthUser) authentication.getPrincipal();
        }
        return authUser;
    }

    protected Long getCurrentAuthUserId() {
        PBAuthUser authUser = getCurrentAuthUser();

        if (null != authUser) {
            return authUser.getId();
        } else {
            log.warn("could not get current user id");
            return -1L;
        }
    }

    @Override
    public void accept(Long id) {

        Long userId = getCurrentAuthUserId();
        User user = userDAO.findOne(userId);
        Staff staff = user.getStaff();

        if (null == staff) {
            throw new IllegalArgumentException("not found staff for user, user id : " + userId);
        }

        Long staffId = staff.getId();

        taskService.claim(id.toString(), staffId.toString());

        Map<String, Object> variables = new HashMap<>();
        variables.put("staffId", staffId.toString());
        variables.put("assigned", 0);

        taskService.complete(id.toString(), variables);
    }

    @Override
    public void assign(Long id, Long staffId) {

        Long userId = getCurrentAuthUserId();
        User user = userDAO.findOne(userId);
        Staff assignerStaff = user.getStaff();

        if (null == assignerStaff) {
            throw new IllegalArgumentException("not found assigner staff for user, user id : " + userId);
        }

        Long assignerStaffId = assignerStaff.getId();

        Staff staff = staffDAO.findOne(staffId);

        if (null == staff) {
            throw new IllegalArgumentException("not found staff, staff id : " + staffId);
        }

        taskService.claim(id.toString(), staffId.toString());

        Map<String, Object> variables = new HashMap<>();
        variables.put("staffId", staffId.toString());
        variables.put("assigner", assignerStaffId.toString());
        variables.put("assigned", 1);

        taskService.complete(id.toString(), variables);
    }


    @Override
    public void depart(Long id) {
        taskService.complete(id.toString());
    }

    @Override
    public void execute(Long id) {
        taskService.complete(id.toString());
    }

    @Override
    public void complete(Long id) {
        taskService.complete(id.toString());
    }

    @Override
    public void confirm(Long id) {
        taskService.complete(id.toString());
    }
}
