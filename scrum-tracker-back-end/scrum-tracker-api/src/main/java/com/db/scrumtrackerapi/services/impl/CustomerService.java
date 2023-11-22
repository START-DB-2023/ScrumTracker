package com.db.scrumtrackerapi.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.repositories.CustomerRepository;
import com.db.scrumtrackerapi.security.service.TokenService;
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

    @Autowired
    TokenService tokenService;

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

    /**
     * Updates the information of an existing customer.
     *
     * This method retrieves the customer with the given email, checks if it's active, and then updates its
     * information with the provided customer object. The updated customer is then saved to the repository.
     *
     * @param customer The customer object containing the updated information.
     * @return The updated customer.
     * @throws EntityNotFoundException If the customer with the specified email is not found or is not active.
     */
    @Override
    public Customer update(Customer customer) {
        Optional<Customer> savedCustomer = findByEmail(customer.getEmail());
        if (savedCustomer.isPresent() && savedCustomer.get().isActive()) {
            Customer newCustomer = savedCustomer.get().update(customer);
            return customerRepository.save(newCustomer);
        }
        else{
            throw new EntityNotFoundException("Customer with email " + customer.getEmail() + " was not found.");        }
    }
    
}
