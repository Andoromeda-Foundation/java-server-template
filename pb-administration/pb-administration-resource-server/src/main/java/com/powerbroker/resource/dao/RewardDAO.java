package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Reward;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wjwjtftf
 */
@Repository
public interface RewardDAO extends JpaRepository<Reward, Long> {
}
