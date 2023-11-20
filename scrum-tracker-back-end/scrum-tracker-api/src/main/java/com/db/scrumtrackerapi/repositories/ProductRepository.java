package com.db.scrumtrackerapi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.scrumtrackerapi.model.Product;

/**
 * Repository interface for {@link Product} entities.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Retrieves the product with the highest ID.
     *
     * @return The product with the highest ID.
     */
    @Query(value = "SELECT p FROM Product p WHERE p.id = (SELECT MAX(p2.id) FROM Product p2 WHERE p2.active = true)")
    Product getLast();

}
