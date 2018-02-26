package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.ElectricParameter;

/**
 * @author william
 */
@Repository
public interface ElectricParameterDAO extends JpaRepository<ElectricParameter, Long> {
}
