package com.db.scrumtrackerapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Configuration class for Spring Security filters, providing security settings for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityFilters {

    @Autowired
    private FilterToken filterToken;
    
    /**
     * Configures the default security filter chain with specific settings.
     *
     * @param http the {@link HttpSecurity} object to configure security settings.
     * @return the configured {@link SecurityFilterChain}.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                //should be enabled in production environment
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> 
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(new AntPathRequestMatcher("/login", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/register", "POST")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/update", "POST")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/customer", "GET")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/customer", "DELETE")).hasRole("ADMIN")

                                .requestMatchers(new AntPathRequestMatcher("/item-backlog", "POST")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/item-backlog", "PUT")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/item-backlog", "DELETE")).hasAnyRole("ADMIN", "SM", "PO")
                                
                                .requestMatchers(new AntPathRequestMatcher("/product-backlog", "POST")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/product-backlog", "PUT")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/product-backlog", "DELETE")).hasAnyRole("ADMIN", "SM", "PO")
                                
                                .requestMatchers(new AntPathRequestMatcher("/product", "POST")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/product", "PUT")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/product", "DELETE")).hasAnyRole("ADMIN", "SM", "PO")

                                .requestMatchers(new AntPathRequestMatcher("/sprint", "POST")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/sprint", "PUT")).hasAnyRole("ADMIN", "SM", "PO")
                                .requestMatchers(new AntPathRequestMatcher("/sprint", "DELETE")).hasAnyRole("ADMIN", "SM", "PO")

                                .requestMatchers(new AntPathRequestMatcher("/task-sprint", "POST")).authenticated()
                                .requestMatchers(new AntPathRequestMatcher("/task-sprint", "PUT")).authenticated()
                                .requestMatchers(new AntPathRequestMatcher("/task-sprint", "DELETE")).authenticated()

                                .anyRequest().permitAll()
                                .and().addFilterBefore(filterToken, UsernamePasswordAuthenticationFilter.class)
                );
        return http.build();
    }

}
