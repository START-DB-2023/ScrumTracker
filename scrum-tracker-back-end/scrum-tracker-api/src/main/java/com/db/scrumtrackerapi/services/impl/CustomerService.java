package com.db.scrumtrackerapi.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.repositories.CustomerRepository;
import com.db.scrumtrackerapi.services.ICustomerService;

/**
 * Service class for managing customer-related operations.
 *
 * <p>This service provides methods to find customers by email and to save customer entities.
 */
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Finds a customer by their email address.
     *
     * @param email The email address of the customer to find.
     * @return Optional containing the customer if found, or empty if not found.
     */
    @Override
    public Optional<Customer> findByEmail(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(customers.get(0));
    }

    /**
     * Saves a customer entity.
     *
     * @param customer The customer entity to save.
     * @return Saved customer if successful.
     */
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    /**
     * Deactivate a {@link customer} entity based on the provided ID.
     *
     * @param id The ID of the {@link customer} entity to be retrieved.
     * @return The {@link customer} entity.
     * @throws EntityNotFoundException If the {@link customer} with the given ID is not found.
     */
    @Override
    public void deactivateByEmail(String email) {
        List<Customer> customer = customerRepository.findByEmail(email);
        if (!customer.isEmpty() && customer.get(0).isActive()) {
            customer.get(0).setActive(false);
        } else {
            throw new EntityNotFoundException("Customer with email " + email + " was not found.");
        }
    }

    @Override
    public Customer update(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
