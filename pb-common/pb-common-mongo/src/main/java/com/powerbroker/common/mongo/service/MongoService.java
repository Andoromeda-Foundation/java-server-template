package com.powerbroker.common.mongo.service;

import com.powerbroker.common.mongo.entity.AuditorEntity;

/**
 * Created by Lionel on 20/9/2016.
 */
public interface MongoService {

    String DAO_SUFFIX_NAME = "DAO";

    <T extends AuditorEntity> void saveMongoEntity(T mongoEntity);

    <T extends AuditorEntity> void asyncSaveMongoEntity(T mongoEntity);

    <T extends AuditorEntity> T findOne(T mongoEntity);
}
