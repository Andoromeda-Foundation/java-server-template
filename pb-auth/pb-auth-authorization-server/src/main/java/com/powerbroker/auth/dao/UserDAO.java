package com.powerbroker.auth.dao;

import com.powerbroker.auth.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
