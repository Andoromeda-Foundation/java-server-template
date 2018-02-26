package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface GpsDAO extends JpaRepository<Gps, Long> {
}
