package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.IndexMapping;

/**
 * @author william
 */
@Repository
public interface IndexMappingDAO extends JpaRepository<IndexMapping, Long> {
}
