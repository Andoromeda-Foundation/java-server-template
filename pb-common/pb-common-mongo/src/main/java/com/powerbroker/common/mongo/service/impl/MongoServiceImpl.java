package com.powerbroker.common.mongo.service.impl;

import com.mongodb.MongoTimeoutException;
import com.powerbroker.common.mongo.entity.AuditorEntity;
import com.powerbroker.common.mongo.service.MongoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.MessageFormat;

/**
 * Created by Lionel on 20/9/2016.
 */
@Slf4j
@Service
public class MongoServiceImpl implements MongoService, BeanFactoryAware {

    @Setter
    private BeanFactory beanFactory;

    @Override
    public <T extends AuditorEntity> void saveMongoEntity(T mongoEntity) {

        Assert.notNull(mongoEntity, "!!! Mongo entity must not be null !!!");

        MongoRepository mongoDAO = getMongoRepository(mongoEntity.getClass().getSimpleName());

        mongoDAO.save(mongoEntity);
    }

    @Async("asyncExecutor")
    @Override
    public <T extends AuditorEntity> void asyncSaveMongoEntity(T mongoEntity) {

        Assert.notNull(mongoEntity, "!!! Mongo entity must not be null !!!");

        MongoRepository mongoDAO = getMongoRepository(mongoEntity.getClass().getSimpleName());

        try {
            mongoDAO.save(mongoEntity);
        } catch (DataAccessResourceFailureException | MongoTimeoutException e) {
            log.error("!!! Mongo DB error !!!", e);
        }
    }

    @Override
    public <T extends AuditorEntity> T findOne(T mongoEntity) {

        Assert.notNull(mongoEntity, "!!! Mongo entity must not be null !!!");

        MongoRepository mongoDAO = getMongoRepository(mongoEntity.getClass().getSimpleName());

        T returnMongoEntity = null;

        try {
            returnMongoEntity = (T) mongoDAO.findOne(mongoEntity.getId());
        } catch (DataAccessResourceFailureException | MongoTimeoutException e) {
            log.error("!!! Mongo DB error !!!", e);
        }

        return returnMongoEntity;
    }

    private MongoRepository getMongoRepository(String entityName) {

        MongoRepository mongoDAO = BeanFactoryAnnotationUtils.qualifiedBeanOfType(beanFactory,
                MongoRepository.class, entityName + DAO_SUFFIX_NAME);

        Assert.notNull(mongoDAO, MessageFormat.format("!!! MongoRepository {0} must not be null !!!", entityName));

        return mongoDAO;
    }
}
