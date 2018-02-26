package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface DocumentDAO extends JpaRepository<Document, Long> {
}
