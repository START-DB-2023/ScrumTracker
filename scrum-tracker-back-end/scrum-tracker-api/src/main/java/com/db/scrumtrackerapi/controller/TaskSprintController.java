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
import com.db.scrumtrackerapi.model.dto.TaskSprintDTO;
import com.db.scrumtrackerapi.model.view.TaskSprintView;
import com.db.scrumtrackerapi.services.impl.TaskSprintService;

/**
 * Controller class that handles HTTP requests related to tasks within a sprint.
 */
@RestController
@RequestMapping(value = "/task-sprint")
@CrossOrigin("http://localhost:5173/")
public class TaskSprintController {
    
    @Autowired
    TaskSprintService taskSprintService;

    /**
     * Retrieves a task within a sprint by its unique identifier.
     *
     * @param id The unique identifier of the task.
     * @return A ResponseEntity containing the TaskSprintView if found, or an empty body with a status code.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<TaskSprintView> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskSprintService.findById(id).toView());
    }

    /**
     * Deactivates a task within a sprint by its unique identifier.
     *
     * @param id The unique identifier of the task to deactivate.
     * @return A ResponseEntity containing the deactivated TaskSprintView or an empty body with a status code.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<TaskSprintView> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskSprintService.deactivateById(id).toView());
    }

    /**
     * Saves a new task within a sprint using the provided TaskSprintDTO.
     *
     * @param taskSprintDTO The data necessary to create a new task within a sprint.
     * @return A ResponseEntity containing the created TaskSprintView or an empty body with a status code.
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<TaskSprintView> save(@RequestBody TaskSprintDTO taskSprintDTO) {
        return ResponseEntity.ok().body(taskSprintService.save(taskSprintDTO.toTaskSprint()).toView());
    }

    /**
     * Updates an existing task within a sprint with the provided data in the TaskSprintDTO.
     *
     * @param id            The unique identifier of the task to update.
     * @param taskSprintDTO The updated data for the task within a sprint.
     * @return A ResponseEntity containing the updated TaskSprintView or an empty body with a status code.
     */
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<TaskSprintView> update(@PathVariable Long id, @RequestBody TaskSprintDTO taskSprintDTO) {
        return ResponseEntity.ok().body(taskSprintService.update(id, taskSprintDTO.toTaskSprint()).toView());
    }

    /**
     * Retrieves a list of tasks within a sprint by the unique identifier of the sprint.
     *
     * @param id The unique identifier of the sprint.
     * @return A ResponseEntity containing a list of TaskSprintView if found, or an empty body with a status code.
     */
    @RequestMapping(value="/sprint/{id}", method=RequestMethod.GET)
    ResponseEntity<List<TaskSprintView>> getBySprintId(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskSprintService.findBySprintId(id).stream().map(i -> i.toView()).toList());
    }
}
