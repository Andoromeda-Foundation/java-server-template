package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Nav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface NavDAO extends JpaRepository<Nav, Long> {
}
