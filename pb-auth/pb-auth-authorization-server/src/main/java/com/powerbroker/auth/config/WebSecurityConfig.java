package com.powerbroker.auth.config;

import com.powerbroker.auth.service.LogoutSuccessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/**
 * @author william
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService pbAuthUserDetailsService;

    @Resource
    private LogoutSuccessService logoutSuccessService;

    @Resource
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        // using db config http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/
        auth.userDetailsService(pbAuthUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = super.authenticationManagerBean();
        return authenticationManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // TODO: using db config http://stackoverflow.com/questions/31704593/spring-security-authorize-requests-value-from-database
        // TODO: http://stackoverflow.com/questions/21203804/spring-security-url-pattern-matching
        http
//                .addFilterBefore(new SimpleCORSFilter(), ChannelProcessingFilter.class)
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/session/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
                .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login.jsp?authorization_error=true")
                .and()
                // TODO: put CSRF protection back into this endpoint
                .csrf()
                .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                .disable()
                .logout()
                .logoutUrl("/oauth/logout")
                .logoutSuccessHandler(logoutSuccessService)
                .and().csrf().disable()
                .formLogin()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/user")
                .failureUrl("/login?authentication_error=true")
        ;
//                .loginPage("/login.jsp");
    }
}
