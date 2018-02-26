package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RewardFault;

/**
 * @author wjwjtftf
 */
@Repository
public interface RewardFaultDAO extends JpaRepository<RewardFault, Long> {
}
