package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Defect;

/**
 * @author william
 */
@Repository
public interface DefectRecordDAO extends JpaRepository<Defect, Long> {
}
