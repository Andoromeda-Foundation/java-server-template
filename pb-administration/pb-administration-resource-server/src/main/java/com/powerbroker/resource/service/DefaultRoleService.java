package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.RoleDAO;
import com.powerbroker.resource.entity.Role;
import com.powerbroker.resource.model.RoleDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultRoleService extends AbstractJPAService<Long, RoleDTO, Role, RoleDAO> implements RoleService {
}
