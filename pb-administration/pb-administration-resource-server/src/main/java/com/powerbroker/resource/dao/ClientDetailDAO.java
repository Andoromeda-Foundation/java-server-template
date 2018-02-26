package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.ClientDetail;

/**
 * @author william
 */
@Repository
public interface ClientDetailDAO extends JpaRepository<ClientDetail, Long> {
}
