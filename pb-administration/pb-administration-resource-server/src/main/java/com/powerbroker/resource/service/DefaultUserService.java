package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.UserDAO;
import com.powerbroker.resource.entity.User;
import com.powerbroker.resource.model.UserDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultUserService extends AbstractJPAService<Long, UserDTO, User, UserDAO> implements UserService {

    @Override
    public String findDeptLeadersByUserId(Long id) {

        return "1,2";
    }
}