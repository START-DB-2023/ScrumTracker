package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.models.view.CustomerView;
import com.db.scrumtrackerapi.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<CustomerView> getCustomerByEmail(@RequestParam("email") String email) {
        CustomerView customerView = customerService.findByEmail(email).toView();
        return new ResponseEntity<>(customerView, HttpStatus.OK);
    }

}
