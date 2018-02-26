package com.powerbroker.auth.dao;

import com.powerbroker.auth.entity.ClientDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface ClientDetailDAO extends CrudRepository<ClientDetail, Long> {

    ClientDetail findByClientId(String clientId);
}
