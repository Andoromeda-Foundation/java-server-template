package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RegularMeetingPlan;

/**
 * @author william
 */
@Repository
public interface RegularMeetingPlanDAO extends JpaRepository<RegularMeetingPlan, Long> {
}
