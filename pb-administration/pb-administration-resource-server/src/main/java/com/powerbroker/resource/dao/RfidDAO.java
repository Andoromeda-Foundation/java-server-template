package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Rfid;

/**
 * @author william
 */
@Repository
public interface RfidDAO extends JpaRepository<Rfid, Long> {
}
