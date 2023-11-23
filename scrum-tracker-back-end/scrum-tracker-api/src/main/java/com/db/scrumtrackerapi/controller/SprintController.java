package com.db.scrumtrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.view.DetailedSprintView;
import com.db.scrumtrackerapi.model.dto.SprintDTO;
import com.db.scrumtrackerapi.services.impl.SprintService;

/**
 * Controller for handling Sprint-related operations.
 */
@RestController
@RequestMapping(value = "/sprint")
@CrossOrigin("http://localhost:5173/")
public class SprintController {
    
    @Autowired
    SprintService sprintService;

    /**
     * Retrieves a detailed view of a alls Sprints
     *
     * @return List of ResponseEntity containing the DetailedSprintView of all Sprints.
     */
    @RequestMapping(value="/", method=RequestMethod.GET)
    ResponseEntity<List<DetailedSprintView>> getAll() {
        return ResponseEntity.ok().body(sprintService.getAllSprints().stream().map(i -> i.toDetailedView()).toList());
    }

    /**
     * Retrieves a detailed view of a Sprint by its ID.
     *
     * @param id The ID of the Sprint to retrieve.
     * @return ResponseEntity containing the DetailedSprintView of the specified Sprint.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<DetailedSprintView> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sprintService.findById(id).toDetailedView());
    }

    /**
     * Deactivates a Sprint by its ID.
     *
     * @param id The ID of the Sprint to deactivate.
     * @return ResponseEntity containing the DetailedSprintView of the deactivated Sprint.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<DetailedSprintView> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sprintService.deactivateById(id).toDetailedView());
    }

    /**
     * Saves a new Sprint using the provided SprintDTO.
     *
     * @param sprintDTO The SprintDTO containing information for the new Sprint.
     * @return ResponseEntity containing the DetailedSprintView of the saved Sprint.
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<DetailedSprintView> save(@RequestBody SprintDTO sprintDTO) {
        return ResponseEntity.ok().body(sprintService.save(sprintDTO.toSprint()).toDetailedView());
    }

    /**
     * Updates an existing Sprint with the provided SprintDTO.
     *
     * @param id The ID of the Sprint to update.
     * @param sprintDTO The SprintDTO containing updated information for the Sprint.
     * @return ResponseEntity containing the DetailedSprintView of the updated Sprint.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<DetailedSprintView> update(@PathVariable Long id, @RequestBody SprintDTO sprintDTO) {
        return ResponseEntity.ok().body(sprintService.update(id, sprintDTO.toSprint()).toDetailedView());
    }

    /**
     * Retrieves a list of detailed views of Sprints associated with a specific Item Backlog ID.
     *
     * @param id The ID of the Item Backlog to retrieve associated Sprints.
     * @return ResponseEntity containing a list of DetailedSprintViews.
     */
    @RequestMapping(value="/item-backlog/{id}", method=RequestMethod.GET)
    ResponseEntity<List<DetailedSprintView>> getByItemBacklogId(@PathVariable Long id) {
        return ResponseEntity.ok().body(sprintService.findByItemBacklogId(id).stream().map(i -> i.toDetailedView()).toList());
    }
}

