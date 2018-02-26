package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.IndexMappingDAO;
import com.powerbroker.resource.entity.IndexMapping;
import com.powerbroker.resource.model.IndexMappingDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultIndexMappingService extends AbstractJPAService<Long, IndexMappingDTO, IndexMapping, IndexMappingDAO> implements IndexMappingService {

}
