package com.powerbroker.resource.config;

import com.powerbroker.common.utils.Constants;
import com.powerbroker.resource.model.UrlMappingDTO;
import com.powerbroker.resource.service.UrlMappingService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author william
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private JedisConnectionFactory jedisConnectionFactory;

    @Resource(authenticationType = Resource.AuthenticationType.APPLICATION)
    private TokenStore redisTokenStore;

    @Resource
    private UrlMappingService urlMappingService;

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(jedisConnectionFactory);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(Constants.OAUTH2_DEFAULT_RESOURCE_ID).tokenStore(redisTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        List<UrlMappingDTO> urlMappingDTOS = urlMappingService.listAllActive();

        Set<String> pathSet = new HashSet<>();

        for (UrlMappingDTO urlMappingDTO : urlMappingDTOS) {
            String[] pathMappings = urlMappingDTO.getUrl().split("/");
            String path = pathMappings[1];

            if (!pathSet.contains(path) && !path.contains("updater") && !path.contains("{{TargetPath}}")) {
                pathSet.add(path);
            }
        }

        for (String path : pathSet) {
            String authorizedPath = String.join(path, "/", "/**");
            http.requestMatchers().antMatchers(authorizedPath).and()
                    .authorizeRequests().antMatchers(authorizedPath).access(
                    "#oauth2.clientHasRole('ADMIN')  or " +
                            "#oauth2.clientHasRole('USER')  or " +
                            "#oauth2.clientHasRole('BSS_ADMIN') or " +
                            "#oauth2.clientHasRole('BSS_USER')  or " +
                            "#oauth2.hasScope('write')");
        }
    }
}