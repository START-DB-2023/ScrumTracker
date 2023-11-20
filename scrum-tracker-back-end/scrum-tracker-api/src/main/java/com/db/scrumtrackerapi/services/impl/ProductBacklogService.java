package com.db.scrumtrackerapi.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.ProductBacklog;
import com.db.scrumtrackerapi.repositories.ProductBacklogRepository;
import com.db.scrumtrackerapi.services.IProductBacklogService;

/**
 * Service class for managing {@link ProductBacklog} entities.
 * Implements the {@link IProductBacklogService} interface.
 */
@Service
public class ProductBacklogService implements IProductBacklogService {

    @Autowired
    ProductBacklogRepository productBacklogRepository;

    /**
     * Saves a new or existing {@link ProductBacklog} entity.
     *
     * @param productBacklog The {@link ProductBacklog} entity to be saved.
     * @return The saved {@link ProductBacklog} entity.
     */
    @Override
    public ProductBacklog save(ProductBacklog productBacklog) {
        return productBacklogRepository.save(productBacklog);
    }

    /**
     * Finds a {@link ProductBacklog} entity by its associated product ID.
     *
     * @param productId The product ID associated with the {@link ProductBacklog} entity.
     * @return The found {@link ProductBacklog} entity.
     */
    @Override
    public ProductBacklog findByProductId(Long productId) {
        ProductBacklog productBacklog = productBacklogRepository.findByProductId(productId);
        if (productBacklog.isActive()) {
            return productBacklog;
        } else {
            throw new EntityNotFoundException("ProductBacklog with Product id " + productId + " was not found or is not active.");
        }
    }

    /**
     * Finds a {@link ProductBacklog} entity by its ID.
     * Throws {@link EntityNotFoundException} if the entity is not found or is not active.
     *
     * @param id The ID of the {@link ProductBacklog} entity.
     * @return The found and active {@link ProductBacklog} entity.
     * @throws EntityNotFoundException If the entity is not found or is not active.
     */
    @Override
    public ProductBacklog findById(Long id) {
        Optional<ProductBacklog> productBacklog = productBacklogRepository.findById(id);
        if (productBacklog.isPresent() && productBacklog.get().isActive()) {
            return productBacklog.get();
        } else {
            throw new EntityNotFoundException("ProductBacklog with id " + id + " was not found or is not active.");
        }
    }

    /**
     * Deactivates a {@link ProductBacklog} entity by its ID.
     * Throws {@link EntityNotFoundException} if the entity is not found or is not active.
     *
     * @param id The ID of the {@link ProductBacklog} entity.
     * @return The deactivated {@link ProductBacklog} entity.
     * @throws EntityNotFoundException If the entity is not found or is not active.
     */
    @Override
    public ProductBacklog desactivateById(Long id) {
        Optional<ProductBacklog> productBacklog = productBacklogRepository.findById(id);
        if (productBacklog.isPresent() && productBacklog.get().isActive()) {
            productBacklog.get().setActive(false);
            return productBacklogRepository.save(productBacklog.get());
        } else {
            throw new EntityNotFoundException("ProductBacklog with id " + id + " was not found or is not active.");
        }
    }
}

