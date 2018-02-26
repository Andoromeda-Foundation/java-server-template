package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.District;

/**
 * @author william
 */
@Repository
public interface DistrictDAO extends JpaRepository<District, Long> {
}
