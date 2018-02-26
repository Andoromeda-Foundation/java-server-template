package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Repair;

/**
 * @author william
 */
@Repository
public interface RepairDAO extends JpaRepository<Repair, Long> {
}
