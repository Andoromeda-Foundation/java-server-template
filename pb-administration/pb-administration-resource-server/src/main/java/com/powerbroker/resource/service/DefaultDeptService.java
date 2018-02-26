package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.DeptDAO;
import com.powerbroker.resource.entity.Dept;
import com.powerbroker.resource.model.DeptDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDeptService extends AbstractJPAService<Long, DeptDTO, Dept, DeptDAO> implements DeptService {

}
