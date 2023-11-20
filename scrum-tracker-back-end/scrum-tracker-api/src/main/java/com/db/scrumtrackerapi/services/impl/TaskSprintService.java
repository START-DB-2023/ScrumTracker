package com.db.scrumtrackerapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.TaskSprint;
import com.db.scrumtrackerapi.repositories.TaskSprintRepository;
import com.db.scrumtrackerapi.services.ITaskSprintService;

/**
 * Service class for handling business logic related to task sprints.
 */
@Service
public class TaskSprintService implements ITaskSprintService {

    @Autowired
    private TaskSprintRepository taskSprintRepository;

    /**
     * Retrieves a list of task sprints by sprint ID, filtering only active task sprints.
     *
     * @param id The ID of the sprint.
     * @return A list of active task sprints.
     */
    public List<TaskSprint> findBySprintId(Long id) {
        return taskSprintRepository.findBySprintId(id).stream().filter(i -> i.isActive()).toList();
    }

    /**
     * Saves a new task sprint.
     *
     * @param taskSprint The task sprint to be saved.
     * @return The saved task sprint.
     */
    @Override
    public TaskSprint save(TaskSprint taskSprint) {
        return taskSprintRepository.save(taskSprint);
    }

    /**
     * Updates an existing task sprint by ID.
     *
     * @param id         The ID of the task sprint to be updated.
     * @param taskSprint The updated task sprint data.
     * @return The updated task sprint.
     * @throws EntityNotFoundException If the task sprint with the given ID is not found.
     */
    @Override
    public TaskSprint updateTaskSprint(Long id, TaskSprint taskSprint) throws EntityNotFoundException {
        Optional<TaskSprint> savedTaskSprintOptional = taskSprintRepository.findById(id);
        if (savedTaskSprintOptional.isPresent()) {
            TaskSprint savedTaskSprint = savedTaskSprintOptional.get().updateTaskSprint(taskSprint);
            return taskSprintRepository.save(savedTaskSprint);
        } else {
            throw new EntityNotFoundException("Task with ID " + taskSprint.getId() + " not found.");
        }
    }

    /**
     * Retrieves a task sprint by ID.
     *
     * @param id The ID of the task sprint to retrieve.
     * @return The retrieved task sprint.
     * @throws EntityNotFoundException If the task sprint with the given ID is not found or is not active.
     */
    @Override
    public TaskSprint findById(Long id) {
        Optional<TaskSprint> taskSprint = taskSprintRepository.findById(id);
        if (taskSprint.isPresent() && taskSprint.get().isActive()) {
            return taskSprint.get();
        } else {
            throw new EntityNotFoundException("TaskSprint with ID " + id + " was not found.");
        }
    }

    /**
     * Deactivates a task sprint by ID.
     *
     * @param id The ID of the task sprint to deactivate.
     * @return The deactivated task sprint.
     * @throws EntityNotFoundException If the task sprint with the given ID is not found or is already inactive.
     */
    @Override
    public TaskSprint deactivateById(Long id) {
        Optional<TaskSprint> taskSprint = taskSprintRepository.findById(id);
        if (taskSprint.isPresent() && taskSprint.get().isActive()) {
            taskSprint.get().setActive(false);
            return taskSprintRepository.save(taskSprint.get());
        } else {
            throw new EntityNotFoundException("TaskSprint with ID " + id + " was not found.");
        }
    }
}
