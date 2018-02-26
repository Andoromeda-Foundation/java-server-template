package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
}
