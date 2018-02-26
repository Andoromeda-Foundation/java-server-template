package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.ClientDAO;
import com.powerbroker.resource.entity.Client;
import com.powerbroker.resource.model.ClientDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultClientService extends AbstractJPAService<Long, ClientDTO, Client, ClientDAO> implements ClientService {

}
