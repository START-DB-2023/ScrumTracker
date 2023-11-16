package com.db.scrumtrackerapi.services;

import java.util.Optional;

import com.db.scrumtrackerapi.model.Customer;

public interface ICustomerService {
    
    Optional<Customer> findByEmail(String email);

    Customer save(Customer customer);
}
