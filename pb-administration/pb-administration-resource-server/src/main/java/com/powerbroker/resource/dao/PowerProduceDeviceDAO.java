package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PowerProduceDevice;

/**
 * @author william
 */
@Repository
public interface PowerProduceDeviceDAO extends JpaRepository<PowerProduceDevice, Long> {
}
