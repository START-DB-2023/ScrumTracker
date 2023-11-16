package com.db.scrumtrackerapi.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.db.scrumtrackerapi.model.Customer;

/**
 * Repository interface for managing {@link Customer} entities.
 * <p> Extends {@link CrudRepository} to provide basic CRUD operations.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
    /**
     * Retrieves a list of customers by their email.
     *
     * @param email The email of the customer.
     * @return A list of customers with the specified email.
     */
    List<Customer> findByEmail(String email);

}
