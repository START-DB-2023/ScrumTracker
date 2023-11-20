package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.model.ProductBacklog;
import com.db.scrumtrackerapi.model.dto.ProductBacklogDTO;
import com.db.scrumtrackerapi.services.impl.ProductBacklogService;

@RestController
@RequestMapping(value="/product-backlog")
public class ProductBacklogController{
    
    @Autowired
    ProductBacklogService productBacklogService;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<ProductBacklog> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productBacklogService.findById(id));
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<ProductBacklog> save(@RequestBody ProductBacklogDTO productBacklogDTO) {
        return ResponseEntity.ok().body(productBacklogService.save(productBacklogDTO.toProductBacklog()));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<ProductBacklog> update(@PathVariable Long id, @RequestBody ProductBacklogDTO productBacklogDTO) {
        return ResponseEntity.ok().body(productBacklogService.update(id, productBacklogDTO.toProductBacklog()));
    }

}
