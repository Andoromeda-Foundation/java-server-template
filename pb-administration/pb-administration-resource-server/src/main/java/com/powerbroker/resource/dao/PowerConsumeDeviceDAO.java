package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PowerConsumeDevice;

/**
 * @author william
 */
@Repository
public interface PowerConsumeDeviceDAO extends JpaRepository<PowerConsumeDevice, Long> {
}
