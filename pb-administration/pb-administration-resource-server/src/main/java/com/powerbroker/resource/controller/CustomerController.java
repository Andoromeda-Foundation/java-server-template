package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.CustomerDTO;
import com.powerbroker.resource.service.CustomerService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController extends AbstractCRUDHandler<Long, CustomerDTO, CustomerService> {

}