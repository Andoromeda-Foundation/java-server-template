package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Customer;

/**
 * @author william
 */
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {
}
