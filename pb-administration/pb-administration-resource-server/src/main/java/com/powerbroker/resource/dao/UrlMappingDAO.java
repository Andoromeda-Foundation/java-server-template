package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface UrlMappingDAO extends JpaRepository<UrlMapping, Long> {

    UrlMapping findByUrlAndHttpMethod(String url, String httpMethod);
}
