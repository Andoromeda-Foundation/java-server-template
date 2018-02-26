package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.VoltageFault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface VoltageFaultDAO extends JpaRepository<VoltageFault, Long> {
}
