package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Trace;

/**
 * @author william
 */
@Repository
public interface TraceDAO extends JpaRepository<Trace, Long> {
}
