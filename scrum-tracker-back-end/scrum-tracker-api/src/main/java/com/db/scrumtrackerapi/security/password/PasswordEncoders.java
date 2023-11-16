package com.db.scrumtrackerapi.security.password;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for creating a BCrypt password encoder bean.
 */
@Configuration
public class PasswordEncoders {
 
    /**
     * Creates a BCrypt password encoder bean.
     *
     * @return a BCryptPasswordEncoder bean.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
