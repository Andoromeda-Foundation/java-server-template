package com.powerbroker.resource.dao;

import com.powerbroker.resource.entity.ReadReceipt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author william
 */
@Repository
public interface ReadReceiptDAO extends MongoRepository<ReadReceipt, String> {

    long countByReadByAndObject(Long readBy, Integer object);
    ReadReceipt findByBulletinId(Long bulletinId);
    Collection<ReadReceipt> findByBulletinIdIn(Collection ids);
}
