package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Insurance;

/**
 * @author william
 */
@Repository
public interface InsuranceDAO extends JpaRepository<Insurance, Long> {
}
