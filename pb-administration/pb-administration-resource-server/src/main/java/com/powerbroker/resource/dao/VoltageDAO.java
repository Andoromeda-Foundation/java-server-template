package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Voltage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author william
 */
@Repository
public interface VoltageDAO extends JpaRepository<Voltage, Long> {

    List<Voltage> findByMetricAtBetween(Date beginAt, Date endAt);
}
