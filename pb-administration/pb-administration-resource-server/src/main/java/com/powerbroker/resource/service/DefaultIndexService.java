package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.IndexDAO;
import com.powerbroker.resource.entity.Index;
import com.powerbroker.resource.model.IndexDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultIndexService extends AbstractJPAService<Long, IndexDTO, Index, IndexDAO> implements IndexService {

}
