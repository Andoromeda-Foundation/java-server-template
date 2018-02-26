package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.WarningLog;

/**
 * @author william
 */
@Repository
public interface WarningLogDAO extends JpaRepository<WarningLog, Long> {
}
