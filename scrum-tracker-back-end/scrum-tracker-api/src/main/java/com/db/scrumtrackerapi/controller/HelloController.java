package com.db.scrumtrackerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.enums.Role;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping(value="/authenticated", method=RequestMethod.GET)
    public ResponseEntity<String> helloCustomer() {
        return new ResponseEntity<>("Hello, You are Authenticated.", HttpStatus.OK);
    }
    

}
