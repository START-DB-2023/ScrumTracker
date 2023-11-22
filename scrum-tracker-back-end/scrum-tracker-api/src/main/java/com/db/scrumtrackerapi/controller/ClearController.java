package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller class providing endpoints to delete data.
 */
@RestController
@CrossOrigin("http://localhost:5173/")
public class ClearController {
    
    @Autowired
    CustomerRepository customerRepository;

    /**
     * Deletes all customer-related data.
     */
    // @RequestMapping(value = "/customer/clear", method = RequestMethod.DELETE)
    // public void clearCustomerData() {
    //     customerRepository.deleteAll();
    // }

    /**
     * Delete customer by id.
     */
    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public void clearCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}

