package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface StaffDAO extends JpaRepository<Staff, Long> {
}
