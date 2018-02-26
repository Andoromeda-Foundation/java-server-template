package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.ElectricalTesting;

/**
 * @author william
 */
@Repository
public interface ElectricalTestingDAO extends JpaRepository<ElectricalTesting, Long> {
}
