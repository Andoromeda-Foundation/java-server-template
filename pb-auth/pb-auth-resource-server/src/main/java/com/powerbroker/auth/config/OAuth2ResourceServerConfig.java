package com.powerbroker.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

/**
 * @author william
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String POWER_BROKER_RESOURCE_ID = "power-broker";

    @Resource
    private TokenStore redisTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(POWER_BROKER_RESOURCE_ID).tokenStore(redisTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                requestMatchers().antMatchers("/user/**")
                .and()
                .authorizeRequests().antMatchers("/user/**").access("#oauth2.clientHasRole('BSS_ADMIN') or #oauth2.hasScope('write')");
    }

    @Bean
    public TokenStore redisTokenStore() {

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setDatabase(1);
        jedisConnectionFactory.afterPropertiesSet();
        return new RedisTokenStore(jedisConnectionFactory);
    }
}