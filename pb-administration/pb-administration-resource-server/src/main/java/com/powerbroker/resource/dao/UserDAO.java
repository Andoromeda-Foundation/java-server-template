package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
