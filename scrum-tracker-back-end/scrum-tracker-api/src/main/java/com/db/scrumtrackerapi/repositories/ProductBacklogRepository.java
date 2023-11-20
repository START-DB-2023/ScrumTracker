package com.db.scrumtrackerapi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.scrumtrackerapi.model.ProductBacklog;

/**
 * Repository interface for {@link ProductBacklog} entities.
 */
@Repository
public interface ProductBacklogRepository extends CrudRepository<ProductBacklog, Long> {

    /**
     * Retrieves the product backlog by product ID.
     *
     * @param productId The ID of the associated product.
     * @return The product backlog associated with the given product ID.
     */
    @Query("SELECT p FROM ProductBacklog p WHERE p.product.id = :productId")
    ProductBacklog findByProductId(@Param("productId") Long id);

}
