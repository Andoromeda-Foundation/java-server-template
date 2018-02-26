package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface AttendanceDAO extends JpaRepository<Attendance, Long> {
}
