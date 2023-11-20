package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMethod;

//Should be excluded in production 
@RestController
public class ClearController {
    
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value="/customer/clear", method=RequestMethod.DELETE)
    public void requestMethodName() {
        customerRepository.deleteAll();
    }

}
