package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.model.dto.ItemBacklogDTO;
import com.db.scrumtrackerapi.model.view.ItemBacklogView;
import com.db.scrumtrackerapi.services.impl.ItemBacklogService;
import java.util.List;

/**
 * Controller class handling HTTP requests related to Item Backlog entities.
 */
@RestController
@RequestMapping(value = "/item-backlog")
@CrossOrigin("http://localhost:5173/")
public class ItemBacklogController {
    
    @Autowired
    ItemBacklogService itemBacklogService;

    /**
     * Retrieves an Item Backlog entity by its unique identifier.
     *
     * @param id The unique identifier of the Item Backlog.
     * @return ResponseEntity containing the ItemBacklogView representing the found entity.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<ItemBacklogView> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.findById(id).toView());
    }

    /**
     * Deactivates an Item Backlog entity by its unique identifier.
     *
     * @param id The unique identifier of the Item Backlog to be deactivated.
     * @return ResponseEntity containing the ItemBacklogView representing the deactivated entity.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<ItemBacklogView> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.deactivateById(id).toView());
    }

    /**
     * Saves a new Item Backlog entity based on the provided ItemBacklogDTO.
     *
     * @param itemBacklogDTO The data transfer object representing the new Item Backlog entity.
     * @return ResponseEntity containing the ItemBacklogView representing the saved entity.
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<ItemBacklogView> save(@RequestBody ItemBacklogDTO itemBacklogDTO) {
        return ResponseEntity.ok().body(itemBacklogService.save(itemBacklogDTO.toItemBacklog()).toView());
    }

    /**
     * Updates an existing Item Backlog entity based on the provided identifier and ItemBacklogDTO.
     *
     * @param id The unique identifier of the Item Backlog to be updated.
     * @param itemBacklogDTO The data transfer object representing the updated data for the Item Backlog.
     * @return ResponseEntity containing the ItemBacklogView representing the updated entity.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<ItemBacklogView> update(@PathVariable Long id, @RequestBody ItemBacklogDTO itemBacklogDTO) {
        return ResponseEntity.ok().body(itemBacklogService.update(id, itemBacklogDTO.toItemBacklog()).toView());
    }

    /**
     * Retrieves a list of Item Backlog entities associated with a specific Product Backlog.
     *
     * @param id The unique identifier of the Product Backlog.
     * @return ResponseEntity containing a list of ItemBacklogView representing the found entities.
     */
    @RequestMapping(value="/product-backlog/{id}", method=RequestMethod.GET)
    ResponseEntity<List<ItemBacklogView>> getByProductBacklogId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.findByProductBacklogId(id).stream().map(i -> i.toView()).toList());
    }

    /**
     * Retrieves a list of Item Backlog entities associated with a specific Sprint.
     *
     * @param id The unique identifier of the Sprint.
     * @return ResponseEntity containing a list of ItemBacklogView representing the found entities.
     */
    @RequestMapping(value="/sprint/{id}", method=RequestMethod.GET)
    ResponseEntity<List<ItemBacklogView>> getBySprintId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.findBySprintId(id).stream().map(i -> i.toView()).toList());
    }
}
