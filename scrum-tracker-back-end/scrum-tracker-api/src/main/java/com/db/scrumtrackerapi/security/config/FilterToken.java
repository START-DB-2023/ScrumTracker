package com.db.scrumtrackerapi.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import com.db.scrumtrackerapi.security.service.CustomerUserDetailsService;
import com.db.scrumtrackerapi.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Custom filter for handling authentication tokens in the HTTP request.
 */
@Service
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    /**
     * Method to perform the filter logic for authentication tokens.
     *
     * @param request     The HTTP servlet request.
     * @param response    The HTTP servlet response.
     * @param filterChain The filter chain.
     * @throws ServletException If a servlet-related error occurs.
     * @throws IOException      If an I/O error occurs.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
 
        String token;
        
        String authorizationHeader = request.getHeader("Authorization");
        
        if(authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");
            String subject = tokenService.getSubject(token);
            UserDetails userDetails = customerUserDetailsService.loadUserByUsername(subject);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request, response);
    }
    
}
