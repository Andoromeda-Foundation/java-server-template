package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.FaultRecord;

/**
 * @author william
 */
@Repository
public interface FaultRecordDAO extends JpaRepository<FaultRecord, Long> {
}
