package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.EventLog;

/**
 * @author william
 */
@Repository
public interface EventLogDAO extends JpaRepository<EventLog, Long> {
}
