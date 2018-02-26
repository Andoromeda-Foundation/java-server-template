package com.powerbroker.common.mongo.dao;

import com.powerbroker.common.mongo.entity.SystemLogMongo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 * Created by Lionel on 10/10/2016.
 */
@Qualifier("SystemLogMongoDAO")
public interface SystemLogMongoDAO extends MongoRepository<SystemLogMongo, Serializable> {

}
