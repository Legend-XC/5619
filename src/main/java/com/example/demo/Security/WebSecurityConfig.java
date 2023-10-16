package com.example.demo.Security;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(String.valueOf(PathRequest.toStaticResources().atCommonLocations())).permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLoginConfigurer -> formLoginConfigurer
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .permitAll())
                .logout(logoutConfigurer -> logoutConfigurer
                        .logoutUrl("/logout")
                        .permitAll());

        return http.build();
    }
}