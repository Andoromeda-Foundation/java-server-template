package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.FaultRepository;

/**
 * @author william
 */
@Repository
public interface FaultRepositoryDAO extends JpaRepository<FaultRepository, Long> {
}
