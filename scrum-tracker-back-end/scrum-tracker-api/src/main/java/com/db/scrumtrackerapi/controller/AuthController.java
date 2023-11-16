package com.db.scrumtrackerapi.controller;

import java.security.Principal;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.model.dto.LoginDTO;
import com.db.scrumtrackerapi.security.service.TokenService;

@RestController
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login")
    public String login(@RequestBody LoginDTO login) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
            new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
            try {
                Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                UserDetails user = (UserDetails) authenticate.getPrincipal();
                return tokenService.generateToken(user);
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
