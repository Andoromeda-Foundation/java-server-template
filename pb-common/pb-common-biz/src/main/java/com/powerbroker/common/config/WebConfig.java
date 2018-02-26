package com.powerbroker.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author william
 */
public class WebConfig {

    @Bean
    public FilterRegistrationBean userInsertingMdcFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        SimpleCORSFilter userFilter = new SimpleCORSFilter();
        registrationBean.setFilter(userFilter);
        registrationBean.setOrder(0);
        return registrationBean;
    }
}
