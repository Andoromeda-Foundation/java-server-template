package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Vehicle;

/**
 * @author william
 */
@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, Long> {
}
