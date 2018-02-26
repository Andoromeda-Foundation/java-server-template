package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Enterprise;

/**
 * @author william
 */
@Repository
public interface EnterpriseDAO extends JpaRepository<Enterprise, Long> {
}
