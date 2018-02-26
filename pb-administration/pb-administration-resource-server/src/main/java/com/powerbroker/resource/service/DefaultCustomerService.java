package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.CustomerDAO;
import com.powerbroker.resource.entity.Customer;
import com.powerbroker.resource.model.CustomerDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultCustomerService extends AbstractJPAService<Long, CustomerDTO, Customer, CustomerDAO> implements CustomerService {

}
