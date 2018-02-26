package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.SidebarDAO;
import com.powerbroker.resource.entity.Sidebar;
import com.powerbroker.resource.model.SidebarDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultSidebarService extends AbstractJPAService<Long, SidebarDTO, Sidebar, SidebarDAO> implements
        SidebarService {

}
