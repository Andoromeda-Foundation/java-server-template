package com.powerbroker.common.mongo.dao;

import com.powerbroker.common.mongo.entity.PlcCommandMongo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 * Created by Lionel on 20/9/2016.
 */
@Qualifier("PlcCommandMongoDAO")
public interface PlcCommandMongoDAO extends MongoRepository<PlcCommandMongo, Serializable> {

}
