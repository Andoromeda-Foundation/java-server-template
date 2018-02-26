package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.StaffDAO;
import com.powerbroker.resource.entity.Staff;
import com.powerbroker.resource.model.StaffDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultStaffService extends AbstractJPAService<Long, StaffDTO, Staff, StaffDAO> implements StaffService {

}