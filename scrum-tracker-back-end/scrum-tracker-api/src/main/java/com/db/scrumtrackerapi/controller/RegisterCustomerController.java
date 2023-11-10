package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.dtos.CustomerDTO;
import com.db.scrumtrackerapi.models.view.CustomerView;
import com.db.scrumtrackerapi.repositories.CustomerRepository;

@RestController
public class RegisterCustomerController {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value="/register", method=RequestMethod.POST, consumes = "application/json" )
    public ResponseEntity<CustomerView> registerUser(@RequestBody CustomerDTO customerDTO){
        Customer savedCustomer = null;
        ResponseEntity<CustomerView> response = null;

        try {
            Customer customer = customerDTO.toCustomer(passwordEncoder);
            savedCustomer = customerRepository.save(customer);
            
            if (savedCustomer.getId() > 0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedCustomer.toView());
            }

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }

        return response;
    }

}
