package com.db.scrumtrackerapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.security.config.Customizer.withDefaults;

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
                .cors(withDefaults())
                //should be enabled in production environment
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> 
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(new AntPathRequestMatcher("/login", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/hello")).authenticated()
                                .anyRequest().permitAll()
                                .and().addFilterBefore(filterToken, UsernamePasswordAuthenticationFilter.class)
                );
        return http.build();
    }

}
