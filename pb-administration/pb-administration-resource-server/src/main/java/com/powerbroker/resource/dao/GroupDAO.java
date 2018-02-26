package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Group;

/**
 * @author william
 */
@Repository
public interface GroupDAO extends JpaRepository<Group, Long> {
}
