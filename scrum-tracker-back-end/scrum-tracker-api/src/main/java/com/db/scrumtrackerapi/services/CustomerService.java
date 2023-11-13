package com.db.scrumtrackerapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).get(0);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    
}
