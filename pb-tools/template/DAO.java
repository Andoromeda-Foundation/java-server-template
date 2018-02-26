package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.{{Target}};

/**
 * @author william
 */
@Repository
public interface {{Target}}DAO extends JpaRepository<{{Target}}, Long> {
}
