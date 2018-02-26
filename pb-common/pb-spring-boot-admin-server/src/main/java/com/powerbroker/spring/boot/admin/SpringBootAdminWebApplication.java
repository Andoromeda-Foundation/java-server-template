package com.powerbroker.spring.boot.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lionel on 3/12/2016.
 */
@Configuration
@SpringBootApplication
//@EnableDiscoveryClient
@EnableAdminServer
public class SpringBootAdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminWebApplication.class, args);
    }
}
