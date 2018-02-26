package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.GpsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface GpsAccountDAO extends JpaRepository<GpsAccount, Long> {
}
