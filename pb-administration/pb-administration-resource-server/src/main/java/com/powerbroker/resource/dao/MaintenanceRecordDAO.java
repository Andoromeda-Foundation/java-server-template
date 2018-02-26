package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.MaintenanceRecord;

/**
 * @author william
 */
@Repository
public interface MaintenanceRecordDAO extends JpaRepository<MaintenanceRecord, Long> {
}
