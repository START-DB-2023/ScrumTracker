package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.dto.ItemBacklogDTO;
import com.db.scrumtrackerapi.services.impl.ItemBacklogService;
import java.util.List;

@RestController
@RequestMapping(value = "/item-backlog")
public class ItemBacklogController {
    
    @Autowired
    ItemBacklogService itemBacklogService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<ItemBacklog> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.findById(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<ItemBacklog> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.deactivateById(id));
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<ItemBacklog> save(@RequestBody ItemBacklogDTO itemBacklogDTO) {
        return ResponseEntity.ok().body(itemBacklogService.save(itemBacklogDTO.toItemBacklog()));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<ItemBacklog> update(@PathVariable Long id, @RequestBody ItemBacklogDTO itemBacklogDTO) {
        return ResponseEntity.ok().body(itemBacklogService.update(id, itemBacklogDTO.toItemBacklog()));
    }

    @RequestMapping(value="/product-backlog/{id}", method=RequestMethod.GET)
    ResponseEntity<List<ItemBacklog>> getByProductBacklogId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.findByProductBacklogId(id));
    }

    @RequestMapping(value="/sprint/{id}", method=RequestMethod.GET)
    ResponseEntity<List<ItemBacklog>> getBySprintId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemBacklogService.findBySprintId(id));
    }
}
