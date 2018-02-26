package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.ProtectionDeviceWorkingRecord;

/**
 * @author william
 */
@Repository
public interface ProtectionDeviceWorkingRecordDAO extends JpaRepository<ProtectionDeviceWorkingRecord, Long> {
}
