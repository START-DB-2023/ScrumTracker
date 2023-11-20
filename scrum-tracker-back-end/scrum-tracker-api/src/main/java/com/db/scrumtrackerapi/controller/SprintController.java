package com.db.scrumtrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.dto.SprintDTO;
import com.db.scrumtrackerapi.services.impl.SprintService;

@RestController
@RequestMapping(value = "/sprint")
public class SprintController {
    
    @Autowired
    SprintService sprintService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<Sprint> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sprintService.findById(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<Sprint> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sprintService.deactivateById(id));
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<Sprint> save(@RequestBody SprintDTO sprintDTO) {
        return ResponseEntity.ok().body(sprintService.save(sprintDTO.toSprint()));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<Sprint> update(@PathVariable Long id, @RequestBody SprintDTO sprintDTO) {
        return ResponseEntity.ok().body(sprintService.update(id, sprintDTO.toSprint()));
    }

    @RequestMapping(value="/item-backlog/{id}", method=RequestMethod.GET)
    ResponseEntity<List<Sprint>> getByItemBacklogId(@PathVariable Long id) {
        return ResponseEntity.ok().body(sprintService.findByItemBacklogId(id));
    }

}
