package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.ArresterActionRecord;

/**
 * @author william
 */
@Repository
public interface ArresterActionRecordDAO extends JpaRepository<ArresterActionRecord, Long> {
}
