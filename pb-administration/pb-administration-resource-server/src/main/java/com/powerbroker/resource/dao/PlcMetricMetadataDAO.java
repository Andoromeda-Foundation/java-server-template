package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.PlcMetricMetadata;

/**
 * @author william
 */
@Repository
public interface PlcMetricMetadataDAO extends JpaRepository<PlcMetricMetadata, PlcMetricMetadata.PlcMetricMetadataPK> {
}
