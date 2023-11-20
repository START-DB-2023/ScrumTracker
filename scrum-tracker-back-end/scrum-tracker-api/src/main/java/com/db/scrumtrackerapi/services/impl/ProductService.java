package com.db.scrumtrackerapi.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.repositories.ProductRepository;
import com.db.scrumtrackerapi.services.IProductService;

import jakarta.persistence.EntityNotFoundException;


/**
 * Service class for handling business logic related to products.
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves the last active product.
     *
     * @return The last active product.
     * @throws EntityNotFoundException If there are no registered products.
     */
    @Override
    public Product getLast() {
        Product product = productRepository.getLast();
        if (product != null) {
            return product;
        } else {
            throw new EntityNotFoundException("There are no registered products.");
        }
    }

    /**
     * Saves a new product.
     *
     * @param product The product to be saved.
     * @return The saved product.
     */
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates an existing product by ID.
     *
     * @param id      The ID of the product to be updated.
     * @param product The updated product data.
     * @return The updated product.
     * @throws EntityNotFoundException If the product with the given ID is not found.
     */
    @Override
    public Product update(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get().updateProduct(product);
            return productRepository.save(updatedProduct);
        } else {
            throw new EntityNotFoundException("Product with ID " + product.getId() + " not found");
        }
    }

    /**
     * Retrieves a product by ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved product.
     * @throws EntityNotFoundException If the product with the given ID is not found or is not active.
     */
    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent() && product.get().isActive()) {
            return product.get();
        } else {
            throw new EntityNotFoundException("Product with ID " + id + " not found or is not active");
        }
    }

    /**
     * Deactivates a product by ID.
     *
     * @param id The ID of the product to deactivate.
     * @return The deactivated product.
     * @throws EntityNotFoundException If the product with the given ID is not found or is already inactive.
     */
    @Override
    public Product deactivateById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent() && product.get().isActive()) {
            product.get().setActive(false);
            return productRepository.save(product.get());
        } else {
            throw new EntityNotFoundException("Product with ID " + id + " not found or is already inactive");
        }
    }
}
