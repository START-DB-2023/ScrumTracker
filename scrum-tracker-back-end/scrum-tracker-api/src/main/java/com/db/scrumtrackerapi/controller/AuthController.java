package com.db.scrumtrackerapi.controller;

import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.TokenMessage;
import com.db.scrumtrackerapi.model.dto.LoginDTO;
import com.db.scrumtrackerapi.security.service.TokenService;
import com.db.scrumtrackerapi.services.CustomerService;

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
    public ResponseEntity<TokenMessage> login(@RequestBody LoginDTO login) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
            new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
            try {
                Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                UserDetails user = (UserDetails) authenticate.getPrincipal();
                Customer customer = customerService.findByEmail(user.getUsername()).get();
                String token = tokenService.generateToken(user);
                TokenMessage responseBody = new TokenMessage(token, customer.getName(), customer.getLastName());
                return ResponseEntity.ok().body(responseBody);
            }
            catch (DisabledException ex) {
                throw new AuthenticationException("User " + login.getEmail() + " is disabled.");
            }
            catch (LockedException ex) {
                throw new AuthenticationException("User " + login.getEmail() + " is locked.");
            }
            catch(BadCredentialsException ex) {
                throw new AuthenticationException("Bad credentials.");
            }
    }
}
