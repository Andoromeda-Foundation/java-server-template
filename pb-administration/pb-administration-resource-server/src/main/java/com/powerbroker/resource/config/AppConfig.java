package com.powerbroker.resource.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerbroker.common.config.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

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
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(this.jedisConnectionFactory.getPoolConfig());
        jedisConnectionFactory.setHostName(this.jedisConnectionFactory.getHostName());
        jedisConnectionFactory.setPassword(this.jedisConnectionFactory.getPassword());
        jedisConnectionFactory.setPort(this.jedisConnectionFactory.getPort());
        jedisConnectionFactory.setTimeout(this.jedisConnectionFactory.getTimeout());
        jedisConnectionFactory.setUsePool(this.jedisConnectionFactory.getUsePool());
        jedisConnectionFactory.setShardInfo(this.jedisConnectionFactory.getShardInfo());
        jedisConnectionFactory.setDatabase(2);
        jedisConnectionFactory.afterPropertiesSet();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
