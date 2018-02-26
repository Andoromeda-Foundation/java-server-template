package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Dept;

/**
 * @author william
 */
@Repository
public interface DeptDAO extends JpaRepository<Dept, Long> {
}
