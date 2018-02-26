package com.powerbroker.auth.config;

import com.powerbroker.common.config.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

/**
 * @author william
 */
@Configuration
@Import({WebConfig.class})
public class AppConfig {

    @Resource
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(jedisConnectionFactory);
        return redisTokenStore;
    }
}