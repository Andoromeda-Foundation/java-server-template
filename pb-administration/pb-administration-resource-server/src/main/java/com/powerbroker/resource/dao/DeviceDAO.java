package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Device;

/**
 * @author william
 */
@Repository
public interface DeviceDAO extends JpaRepository<Device, Long> {
}
