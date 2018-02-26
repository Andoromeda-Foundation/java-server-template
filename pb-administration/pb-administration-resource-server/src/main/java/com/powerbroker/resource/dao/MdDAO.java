package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.Md;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author william
 */
@Repository
public interface MdDAO extends JpaRepository<Md, Long> {

    List<Md> findByMetricAtBetween(Date beginAt, Date endAt);
}
