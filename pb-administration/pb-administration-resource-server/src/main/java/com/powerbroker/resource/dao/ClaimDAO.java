package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Claim;

/**
 * @author william
 */
@Repository
public interface ClaimDAO extends JpaRepository<Claim, Long> {
}
