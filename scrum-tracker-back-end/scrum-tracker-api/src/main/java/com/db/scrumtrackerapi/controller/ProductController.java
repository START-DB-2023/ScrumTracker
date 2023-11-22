package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.dto.ProductDTO;
import com.db.scrumtrackerapi.model.view.ProductView;
import com.db.scrumtrackerapi.services.impl.ProductService;


/**
 * Controller class that handles HTTP requests related to products.
 */
@RestController
@RequestMapping(value = "/product")
@CrossOrigin("http://localhost:5173/")
public class ProductController {

    /**
     * Autowired ProductService for handling product-related business logic.
     */
    @Autowired
    ProductService productService;

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return A ResponseEntity containing the view representation of the product and an HTTP status code.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<ProductView> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id).toView());
    }

    /**
     * Deactivates a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return A ResponseEntity containing the view representation of the deactivated product and an HTTP status code.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<ProductView> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id).toView());
    }

    /**
     * Retrieves the last product.
     *
     * @return A ResponseEntity containing the view representation of the last product and an HTTP status code.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<ProductView> getLast() {
        return ResponseEntity.ok().body(productService.getLast().toView());
    }

    /**
     * Saves a new product using the provided ProductDTO.
     *
     * @param productDTO The ProductDTO containing information for creating the new product.
     * @return A ResponseEntity containing the view representation of the saved product and an HTTP status code.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ProductView> save(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok().body(productService.save(productDTO.toProduct()).toView());
    }

    /**
     * Updates an existing product by its unique identifier using the provided ProductDTO.
     *
     * @param id         The unique identifier of the product to update.
     * @param productDTO The ProductDTO containing updated information for the product.
     * @return A ResponseEntity containing the view representation of the updated product and an HTTP status code.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<ProductView> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok().body(productService.update(id, productDTO.toProduct()).toView());
    }
}
