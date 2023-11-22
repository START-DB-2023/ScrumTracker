package com.db.scrumtrackerapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

/**
 * Configuration class for the authentication manager.
 */
@Configuration
public class AuthManager {
    
    /**
     * Bean method to provide an authentication manager based on the provided authentication configuration.
     * 
     * @param authenticationConfiguration The authentication configuration to build the authentication manager.
     * @return An instance of AuthenticationManager.
     * @throws Exception If an error occurs during the creation of the authentication manager.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

