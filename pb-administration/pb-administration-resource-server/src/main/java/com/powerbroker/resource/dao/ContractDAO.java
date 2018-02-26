package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface ContractDAO extends JpaRepository<Contract, Long> {
}
