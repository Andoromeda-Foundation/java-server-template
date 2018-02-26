package com.powerbroker.common.mongo.service.impl;

import com.powerbroker.common.mongo.config.MongoApplication;
import com.powerbroker.common.mongo.entity.PlcCommandMongo;
import com.powerbroker.common.mongo.entity.SystemLogMongo;
import com.powerbroker.common.mongo.service.MongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Lionel on 20/9/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoApplication.class})
public class MongoServiceImplTest {

    @Resource
    private MongoService mongoService;

    @Test
    public void asyncSavePlcCommand() throws Exception {

        PlcCommandMongo plcCommandMongo = new PlcCommandMongo();
//        plcCommandMongo.setC01("123");
//        plcCommandMongo.setC02("678");

        mongoService.asyncSaveMongoEntity(plcCommandMongo);
        Thread.sleep(2000);
    }

    @Test
    public void saveSysLog() throws Exception {

        SystemLogMongo sysLog = new SystemLogMongo("test");
        sysLog.setLv(Level.ERROR);
        sysLog.setCode("abc");
        sysLog.setMsg("error message");
        mongoService.saveMongoEntity(sysLog);
    }

    @Test
    public void asyncSaveSysLog() throws Exception {

        SystemLogMongo sysLog = new SystemLogMongo("test");
        sysLog.setLv(Level.ERROR);
        sysLog.setCode("abc");
        sysLog.setMsg("error message");
        mongoService.asyncSaveMongoEntity(sysLog);
        Thread.sleep(2000);
    }
}