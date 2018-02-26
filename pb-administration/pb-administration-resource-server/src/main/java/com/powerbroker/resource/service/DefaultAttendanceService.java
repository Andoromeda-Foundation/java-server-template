package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.AttendanceDAO;
import com.powerbroker.resource.entity.Attendance;
import com.powerbroker.resource.model.AttendanceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultAttendanceService extends AbstractJPAService<Long, AttendanceDTO, Attendance, AttendanceDAO> implements AttendanceService {

}
