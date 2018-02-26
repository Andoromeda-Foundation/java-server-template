package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RegularDemandDeclarePlan;

/**
 * @author william
 */
@Repository
public interface RegularDemandDeclarePlanDAO extends JpaRepository<RegularDemandDeclarePlan, Long> {
}
