package com.powerbroker.resource.service;

import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.UserDTO;

/**
 * @author william
 */
public interface UserService extends PageableService<Long, UserDTO> {

    String findDeptLeadersByUserId(Long id);

}
