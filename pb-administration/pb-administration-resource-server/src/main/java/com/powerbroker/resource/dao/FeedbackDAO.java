package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Feedback;

/**
 * @author william
 */
@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Long> {
}
