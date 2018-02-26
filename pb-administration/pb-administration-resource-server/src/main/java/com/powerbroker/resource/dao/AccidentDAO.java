package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Accident;

/**
 * @author william
 */
@Repository
public interface AccidentDAO extends JpaRepository<Accident, Long> {
}
