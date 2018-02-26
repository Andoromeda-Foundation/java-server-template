package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Inspection;

/**
 * @author william
 */
@Repository
public interface InspectionDAO extends JpaRepository<Inspection, Long> {
}
