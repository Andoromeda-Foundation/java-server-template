package com.jk.asset.config;

import com.powerbroker.common.config.JpaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author william
 */
@Slf4j
@Configuration
@Import({JpaConfig.class})
public class AppConfig {

}