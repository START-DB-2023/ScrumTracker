package com.db.scrumtrackerapi.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.services.impl.CustomerService;

/**
 * Service class implementing Spring Security's UserDetailsService.
 * Used to load user-specific data from database for authentication.
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService{
    
    @Autowired
    CustomerService customerService;

    /**
     * Load user-specific data for the given email.
     *
     * @param email The email of the user.
     * @return UserDetails object representing the user's details.
     * @throws UsernameNotFoundException If the user details are not found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String password = null;
        
        List<GrantedAuthority> authorities = null;
        Optional<Customer> customer = customerService.findByEmail(email);

        if(!customer.isPresent()) {
            throw new UsernameNotFoundException("User details not found for the user:" + email);
        }
        else {
            password = customer.get().getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get().getRole().name()));
        }
        return new User(email, password, authorities);
    }

}