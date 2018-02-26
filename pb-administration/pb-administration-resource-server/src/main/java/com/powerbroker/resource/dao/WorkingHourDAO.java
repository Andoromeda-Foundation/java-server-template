package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.WorkingHour;

/**
 * @author william
 */
@Repository
public interface WorkingHourDAO extends JpaRepository<WorkingHour, Long> {
}
