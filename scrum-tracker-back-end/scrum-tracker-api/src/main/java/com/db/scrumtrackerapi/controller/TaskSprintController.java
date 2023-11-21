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

import com.db.scrumtrackerapi.model.TaskSprint;
import com.db.scrumtrackerapi.model.dto.TaskSprintDTO;
import com.db.scrumtrackerapi.services.impl.TaskSprintService;

@RestController
@RequestMapping(value = "/task-sprint")
@CrossOrigin("http://localhost:5173/")
public class TaskSprintController {
    
    @Autowired
    TaskSprintService taskSprintService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<TaskSprint> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskSprintService.findById(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<TaskSprint> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskSprintService.deactivateById(id));
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<TaskSprint> save(@RequestBody TaskSprintDTO taskSprintDTO) {
        return ResponseEntity.ok().body(taskSprintService.save(taskSprintDTO.toTaskSprint()));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<TaskSprint> update(@PathVariable Long id, @RequestBody TaskSprintDTO taskSprintDTO) {
        return ResponseEntity.ok().body(taskSprintService.update(id, taskSprintDTO.toTaskSprint()));
    }

    @RequestMapping(value="/sprint/{id}", method=RequestMethod.GET)
    ResponseEntity<List<TaskSprint>> getBySprintId(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskSprintService.findBySprintId(id));
    }

}
