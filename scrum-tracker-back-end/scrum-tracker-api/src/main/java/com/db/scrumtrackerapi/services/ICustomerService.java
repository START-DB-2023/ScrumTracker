package com.db.scrumtrackerapi.services;

import com.db.scrumtrackerapi.models.Customer;

public interface ICustomerService {
    
    Customer findByEmail(String email);

    Customer save(Customer customer);
}
