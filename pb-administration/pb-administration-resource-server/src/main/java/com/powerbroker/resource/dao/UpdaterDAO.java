package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Updater;

/**
 * @author william
 */
@Repository
public interface UpdaterDAO extends JpaRepository<Updater, Long> {

}
