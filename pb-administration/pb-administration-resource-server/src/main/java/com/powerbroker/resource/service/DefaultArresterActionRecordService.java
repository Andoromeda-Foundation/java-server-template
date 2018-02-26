package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.ArresterActionRecordDAO;
import com.powerbroker.resource.entity.ArresterActionRecord;
import com.powerbroker.resource.model.ArresterActionRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultArresterActionRecordService extends AbstractJPAService<Long, ArresterActionRecordDTO, ArresterActionRecord, ArresterActionRecordDAO> implements ArresterActionRecordService {

}
