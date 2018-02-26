package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.MaintenanceService;

/**
 * @author william
 */
@Repository
public interface MaintenanceServiceDAO extends JpaRepository<MaintenanceService, Long> {
}
