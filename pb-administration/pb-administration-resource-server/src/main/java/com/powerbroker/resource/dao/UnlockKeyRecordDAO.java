package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.UnlockKeyRecord;

/**
 * @author william
 */
@Repository
public interface UnlockKeyRecordDAO extends JpaRepository<UnlockKeyRecord, Long> {
}
