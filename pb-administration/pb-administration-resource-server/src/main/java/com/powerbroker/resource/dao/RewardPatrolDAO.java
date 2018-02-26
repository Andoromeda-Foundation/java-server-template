package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RewardPatrol;
import com.powerbroker.resource.entity.RewardScore;

/**
 * @author wjwjtftf
 */
@Repository
public interface RewardPatrolDAO extends JpaRepository<RewardPatrol, Long> {
}
