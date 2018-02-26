package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RegularEvaluation;

/**
 * @author william
 */
@Repository
public interface RegularEvaluationDAO extends JpaRepository<RegularEvaluation, Long> {
}
