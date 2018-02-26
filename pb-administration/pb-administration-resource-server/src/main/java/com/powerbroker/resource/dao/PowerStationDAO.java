package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.PowerStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface PowerStationDAO extends JpaRepository<PowerStation, Long> {
}
