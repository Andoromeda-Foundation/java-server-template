package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.HierarchyDAO;
import com.powerbroker.resource.entity.Hierarchy;
import com.powerbroker.resource.model.HierarchyDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultHierarchyService extends AbstractJPAService<Long, HierarchyDTO, Hierarchy, HierarchyDAO> implements HierarchyService {

}
