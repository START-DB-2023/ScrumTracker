package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.dto.ProductBacklogDTO;
import com.db.scrumtrackerapi.model.view.ProductBacklogView;
import com.db.scrumtrackerapi.services.impl.ProductBacklogService;

/**
 * Controller class handling HTTP requests related to product backlogs.
 */
@RestController
@RequestMapping(value="/product-backlog")
@CrossOrigin("http://localhost:5173/")
public class ProductBacklogController {
    
    @Autowired
    ProductBacklogService productBacklogService;

    /**
     * Retrieves a product backlog by its unique identifier.
     *
     * @param id The unique identifier of the product backlog.
     * @return The ResponseEntity containing the product backlog if found, or an empty response if not.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<ProductBacklogView> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productBacklogService.findById(id).toView());
    }

    /**
     * Retrieves a product backlog by the unique identifier of the associated product.
     *
     * @param id The unique identifier of the associated product.
     * @return The ResponseEntity containing the product backlog if found, or an empty response if not.
     */
    @RequestMapping(value="/product/{id}", method=RequestMethod.GET)
    ResponseEntity<ProductBacklogView> getByProductId(@PathVariable Long id) {
        return ResponseEntity.ok().body(productBacklogService.findByProductId(id).toView());
    }

    /**
     * Deactivates a product backlog by its unique identifier.
     *
     * @param id The unique identifier of the product backlog to deactivate.
     * @return The ResponseEntity containing the deactivated product backlog.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<ProductBacklogView> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productBacklogService.desactivateById(id).toView());
    }

    /**
     * Saves a new product backlog based on the provided ProductBacklogDTO.
     *
     * @param productBacklogDTO The DTO containing information to create the product backlog.
     * @return The ResponseEntity containing the saved product backlog.
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<ProductBacklogView> save(@RequestBody ProductBacklogDTO productBacklogDTO) {
        return ResponseEntity.ok().body(productBacklogService.save(productBacklogDTO.toProductBacklog()).toView());
    }

    /**
     * Updates an existing product backlog identified by its unique identifier.
     *
     * @param id The unique identifier of the product backlog to update.
     * @param productBacklogDTO The DTO containing updated information for the product backlog.
     * @return The ResponseEntity containing the updated product backlog.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<ProductBacklogView> update(@PathVariable Long id, @RequestBody ProductBacklogDTO productBacklogDTO) {
        return ResponseEntity.ok().body(productBacklogService.update(id, productBacklogDTO.toProductBacklog()).toView());
    }
}
