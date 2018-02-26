package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Client;

/**
 * @author william
 */
@Repository
public interface ClientDAO extends JpaRepository<Client, Long> {
}
