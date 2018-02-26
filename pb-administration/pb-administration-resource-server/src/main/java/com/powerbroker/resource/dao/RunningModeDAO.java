package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RunningMode;

/**
 * @author william
 */
@Repository
public interface RunningModeDAO extends JpaRepository<RunningMode, Long> {
}
