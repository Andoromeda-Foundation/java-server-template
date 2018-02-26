package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PowerCut;

/**
 * @author william
 */
@Repository
public interface PowerCutDAO extends JpaRepository<PowerCut, Long> {
}
