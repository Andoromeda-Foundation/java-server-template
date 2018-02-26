package com.powerbroker.auth.dao;

import com.powerbroker.auth.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface ClientDAO extends CrudRepository<Client, Long> {

    Client findByUsername(String username);
}
