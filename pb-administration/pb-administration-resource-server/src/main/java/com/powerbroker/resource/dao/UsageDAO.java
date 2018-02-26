package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Usage;

/**
 * @author william
 */
@Repository
public interface UsageDAO extends JpaRepository<Usage, Long> {
}
