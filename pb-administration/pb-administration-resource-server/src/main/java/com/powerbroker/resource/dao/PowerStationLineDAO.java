package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PowerStationLine;

/**
 * @author william
 */
@Repository
public interface PowerStationLineDAO extends JpaRepository<PowerStationLine, Long> {
}
