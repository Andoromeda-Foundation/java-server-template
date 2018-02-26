package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerStationLineDAO;
import com.powerbroker.resource.entity.PowerStationLine;
import com.powerbroker.resource.model.PowerStationLineDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerStationLineService extends AbstractJPAService<Long, PowerStationLineDTO, PowerStationLine, PowerStationLineDAO> implements PowerStationLineService {

}
