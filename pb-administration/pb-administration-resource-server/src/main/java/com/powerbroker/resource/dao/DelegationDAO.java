package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Delegation;

/**
 * @author william
 */
@Repository
public interface DelegationDAO extends JpaRepository<Delegation, Long> {
}
