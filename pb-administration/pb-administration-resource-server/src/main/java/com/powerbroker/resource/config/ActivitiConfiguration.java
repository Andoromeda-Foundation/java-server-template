package com.powerbroker.resource.config;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by wjwjtftf on 2016/12/20.
 */
@Slf4j
@Configuration
public class ActivitiConfiguration extends AbstractProcessEngineAutoConfiguration {

    @Resource
    private DataSource dataSource;

    @Resource
    private PlatformTransactionManager transactionManager;

    @Resource
    private SpringAsyncExecutor springAsyncExecutor;

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration() throws IOException {
        return this.baseSpringProcessEngineConfiguration(dataSource, transactionManager, springAsyncExecutor);
    }

    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService, final TaskService taskService) {

        return (String... strings) -> {
            log.info("{}", Arrays.asList(strings));
            log.info("Activiti: Number of process definitions : [{}]",
                    repositoryService.createProcessDefinitionQuery().count());
            log.info("Activiti: process definitions key : [{}]", repositoryService.createProcessDefinitionQuery().latestVersion().list().get(0).getKey());
            log.info("Activiti: Number of tasks : [{}]", taskService.createTaskQuery().count());
        };
    }
}
