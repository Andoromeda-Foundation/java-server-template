package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Sidebar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author william
 */
@Repository
public interface SidebarDAO extends JpaRepository<Sidebar, Long> {
}
