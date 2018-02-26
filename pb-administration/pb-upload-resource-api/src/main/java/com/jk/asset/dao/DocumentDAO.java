package com.jk.asset.dao;

import com.jk.asset.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface DocumentDAO extends JpaRepository<Document, Long> {
}
