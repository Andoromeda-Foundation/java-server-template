package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.RfidDAO;
import com.powerbroker.resource.entity.Rfid;
import com.powerbroker.resource.model.RfidDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultRfidService extends AbstractJPAService<Long, RfidDTO, Rfid, RfidDAO> implements RfidService {

}
