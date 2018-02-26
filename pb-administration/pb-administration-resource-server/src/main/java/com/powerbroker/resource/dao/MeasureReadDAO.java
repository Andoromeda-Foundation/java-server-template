package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.MeasureRead;

/**
 * @author william
 */
@Repository
public interface MeasureReadDAO extends JpaRepository<MeasureRead, Long> {
}
