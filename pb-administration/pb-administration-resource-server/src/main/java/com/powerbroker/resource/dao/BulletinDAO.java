package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Bulletin;

/**
 * @author william
 */
@Repository
public interface BulletinDAO extends JpaRepository<Bulletin, Long> {

    long countByObject(Integer object);
}
