package com.powerbroker.common.mongo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by Lionel on 20/9/2016.
 */
@Slf4j
@Configuration
@EnableAsync
@ComponentScan({"com.powerbroker.common.mongo.service.impl"})
@EnableMongoRepositories(basePackages = {"com.powerbroker.common.mongo.dao"})
@EnableMongoAuditing
@PropertySource("classpath:/mongo_config.properties")
public class MongoApplication extends AbstractMongoConfiguration {

    @Resource
    protected Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongo.db.name");
    }

    @Override
    public Mongo mongo() throws Exception {

        String[] hosts = env.getProperty("mongo.host", String[].class);
        Integer port = env.getProperty("mongo.port", Integer.class);

        List<ServerAddress> seeds = new ArrayList<>();
        for (String host : hosts) {
            ServerAddress serverAddress = new ServerAddress(host, port);
            seeds.add(serverAddress);
        }

        String user = env.getProperty("mongo.user");

        MongoClient mongoClient;
        if (!StringUtils.isEmpty(user)) {
            mongoClient = userCredentialsMongoClient(seeds, user);
        } else {
            mongoClient = simpleMongoClient(seeds);
        }
        return mongoClient;
    }

    private MongoClient simpleMongoClient(List<ServerAddress> seeds) {
        return new MongoClient(seeds);
    }

    private MongoClient userCredentialsMongoClient(List<ServerAddress> seeds, String user) {

        String password = env.getProperty("mongo.pass");

        String source = this.getDatabaseName();

        List<MongoCredential> mongoCredentials = new ArrayList<>();

        // SHA-1
        mongoCredentials.add(MongoCredential.createScramSha1Credential(user, source, password.toCharArray()));

        // TODO ReplicaSet
        return new MongoClient(seeds, mongoCredentials);
    }

    @Bean

    public MongoTemplate mongoTemplate() throws Exception {

        // remove _class
        MappingMongoConverter converter = this.mappingMongoConverter();
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(this.mongoDbFactory(), converter);

        return mongoTemplate;
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("MongoExecutor-");
        executor.initialize();
        return executor;
    }

}
