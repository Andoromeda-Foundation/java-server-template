package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.MetricFilterMapping;

/**
 * @author william
 */
@Repository
public interface MetricFilterMappingDAO extends JpaRepository<MetricFilterMapping, Long> {
}
