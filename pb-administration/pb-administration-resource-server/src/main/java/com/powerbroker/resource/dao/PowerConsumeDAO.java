package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PowerConsume;

/**
 * @author william
 */
@Repository
public interface PowerConsumeDAO extends JpaRepository<PowerConsume, Long> {
}
