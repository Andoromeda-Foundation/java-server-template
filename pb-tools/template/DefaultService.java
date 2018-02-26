package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.{{Target}}DAO;
import com.powerbroker.resource.entity.{{Target}};
import com.powerbroker.resource.model.{{Target}}DTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class Default{{Target}}Service extends AbstractJPAService<Long, {{Target}}DTO, {{Target}}, {{Target}}DAO> implements {{Target}}Service {

}
