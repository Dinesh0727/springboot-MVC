package com.dinesh.spring_boot.spring_security.spring_security_demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            configurer->
                configurer
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(
                    form -> 
                        form.loginPage("/showLoginForm")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                    )
                .logout(
                    action -> action.permitAll()
                ).exceptionHandling(configurer -> 
                    configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }
}
