package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.GpsAccountDAO;
import com.powerbroker.resource.entity.GpsAccount;
import com.powerbroker.resource.model.gps.AccountDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultGpsAccountService extends AbstractJPAService<Long, AccountDTO, GpsAccount, GpsAccountDAO> implements GpsAccountService {

}
