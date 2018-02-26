package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.RegularInterview;

/**
 * @author william
 */
@Repository
public interface RegularInterviewDAO extends JpaRepository<RegularInterview, Long> {
}
