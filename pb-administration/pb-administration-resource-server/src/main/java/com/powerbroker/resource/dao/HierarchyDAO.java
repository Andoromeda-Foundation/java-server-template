package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Hierarchy;

/**
 * @author william
 */
@Repository
public interface HierarchyDAO extends JpaRepository<Hierarchy, Long> {
}
