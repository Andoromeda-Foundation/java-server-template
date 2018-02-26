package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.WorkRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface WorkRoutineDAO extends JpaRepository<WorkRoutine, Long> {
}
