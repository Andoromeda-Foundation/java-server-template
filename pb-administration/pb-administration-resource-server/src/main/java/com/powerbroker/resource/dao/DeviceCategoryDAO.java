package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.DeviceCategory;

/**
 * @author william
 */
@Repository
public interface DeviceCategoryDAO extends JpaRepository<DeviceCategory, Long> {
}
