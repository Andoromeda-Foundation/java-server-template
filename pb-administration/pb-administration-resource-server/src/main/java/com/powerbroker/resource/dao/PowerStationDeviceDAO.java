package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PowerStationDevice;

/**
 * @author william
 */
@Repository
public interface PowerStationDeviceDAO extends JpaRepository<PowerStationDevice, Long> {
}
