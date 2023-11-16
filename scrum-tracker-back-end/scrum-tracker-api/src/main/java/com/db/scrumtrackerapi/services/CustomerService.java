package com.db.scrumtrackerapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.repositories.CustomerRepository;

import jakarta.persistence.EntityExistsException;

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
     * @throws EntityExistsException case the email is already used.
     */
    @Override
    public Customer save(Customer customer) {
        try {
            return customerRepository.save(customer);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistsException("User " + customer.getEmail() + " already exists.");
        }
    }
    
}
