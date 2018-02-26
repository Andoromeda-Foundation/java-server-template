package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.DistrictDAO;
import com.powerbroker.resource.entity.District;
import com.powerbroker.resource.model.DistrictDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDistrictService extends AbstractJPAService<Long, DistrictDTO, District, DistrictDAO> implements DistrictService {

}
