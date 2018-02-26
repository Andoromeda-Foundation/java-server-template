package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.MdRequest;

/**
 * @author william
 */
@Repository
public interface MdRequestDAO extends JpaRepository<MdRequest, Long> {
}
