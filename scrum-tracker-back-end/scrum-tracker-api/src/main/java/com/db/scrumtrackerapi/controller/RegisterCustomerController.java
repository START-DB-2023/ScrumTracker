package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.dto.CustomerDTO;
import com.db.scrumtrackerapi.model.view.CustomerView;
import com.db.scrumtrackerapi.services.impl.CustomerService;

import jakarta.validation.Valid;

/**
 * Controller class for handling customer registration.
 *
 * <p>This class provides an endpoint ("/register") for registering a customer with the system.
 * It accepts HTTP POST requests with JSON payload representing the customer details.
 */
@RestController
@RequestMapping(value="/register")
public class RegisterCustomerController {
    
    @Autowired
    CustomerService customerService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Handles HTTP POST requests for customer registration.
     *
     * @param customerDTO The customer details received in the request body as JSON.
     * @return ResponseEntity containing the customer information in the response body if the
     *         registration is successful.
     */
    @RequestMapping(value="", method=RequestMethod.POST, consumes = "application/json" )
    public ResponseEntity<CustomerView> registerUser(@Valid @RequestBody CustomerDTO customerDTO){
        
        Customer customer = customerDTO.toCustomer(passwordEncoder);
        Customer savedCustomer = customerService.save(customer);
        
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedCustomer.toView());
    }

}
