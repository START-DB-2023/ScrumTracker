package com.db.scrumtrackerapi.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.services.CustomerService;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
    
    @Autowired
    CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String email = null; 
        String password = null;
        
        List<GrantedAuthority> authorities = null;
        Customer customer = customerService.findByEmail(username);

        if(customer == null) {
            throw new UsernameNotFoundException("User details not found for the user:" + username);
        }
        else {
            email = customer.getEmail();
            password = customer.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getRole().name()));
        }
        return new User(username, password, authorities);
    }
}