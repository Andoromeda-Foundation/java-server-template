package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Index;

/**
 * @author william
 */
@Repository
public interface IndexDAO extends JpaRepository<Index, Long> {
}
