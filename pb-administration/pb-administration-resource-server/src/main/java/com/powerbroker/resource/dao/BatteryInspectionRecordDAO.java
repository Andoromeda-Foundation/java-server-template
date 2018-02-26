package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.BatteryInspectionRecord;

/**
 * @author william
 */
@Repository
public interface BatteryInspectionRecordDAO extends JpaRepository<BatteryInspectionRecord, Long> {
}
