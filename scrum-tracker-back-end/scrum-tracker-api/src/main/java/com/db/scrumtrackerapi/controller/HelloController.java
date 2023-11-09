package com.db.scrumtrackerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.enums.Role;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public ResponseEntity<Customer> helloCustomer(@RequestParam String email, @RequestParam String name, @RequestParam String lastName) {
        Customer customer = new Customer(email, name, lastName, "letmein123", Role.ADMIN);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    

}
