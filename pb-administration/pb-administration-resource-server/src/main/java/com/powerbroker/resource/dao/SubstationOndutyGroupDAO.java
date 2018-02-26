package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.SubstationOndutyGroup;

/**
 * @author william
 */
@Repository
public interface SubstationOndutyGroupDAO extends JpaRepository<SubstationOndutyGroup, Long> {
}
