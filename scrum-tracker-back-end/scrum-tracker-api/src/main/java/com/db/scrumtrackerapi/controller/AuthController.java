package com.db.scrumtrackerapi.controller;

import java.util.Optional;

import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.exceptions.BadEmailException;
import com.db.scrumtrackerapi.exceptions.BadPasswordException;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.dto.LoginDTO;
import com.db.scrumtrackerapi.model.view.TokenMessageView;
import com.db.scrumtrackerapi.security.service.TokenService;
import com.db.scrumtrackerapi.services.impl.CustomerService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenMessageView> login(@RequestBody LoginDTO login) throws AuthenticationException {
        Optional<Customer> customer = customerService.findByEmail(login.getEmail());
        if (customer.isPresent()) {
            try{
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
            new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
                Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                UserDetails user = (UserDetails) authenticate.getPrincipal();
                String token = tokenService.generateToken(user);
                TokenMessageView responseBody = new TokenMessageView(token, customer.get().getName(), customer.get().getLastName(), customer.get().getRole());
                return ResponseEntity.ok().body(responseBody);
            } catch(BadCredentialsException ex) {
                throw new BadPasswordException("The inserted password is wrong.");
            }
        }
        else{
            throw new BadEmailException("The email " + login.getEmail() + " is not registered.");
        }
    }
    
}
