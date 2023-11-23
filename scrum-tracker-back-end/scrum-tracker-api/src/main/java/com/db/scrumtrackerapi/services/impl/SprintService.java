package com.db.scrumtrackerapi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.repositories.SprintRepository;
import com.db.scrumtrackerapi.services.ISprintService;


/**
 * Service class for handling business logic related to sprints.
 */
@Service
public class SprintService implements ISprintService {

    @Autowired
    private SprintRepository sprintRepository;

    /**
     * Retrieves a list of sprints by item backlog ID, filtering only active sprints.
     *
     * @param id The ID of the item backlog.
     * @return A list of active sprints associated with the specified item backlog.
     */
    public List<Sprint> findByItemBacklogId(Long id) {
        return sprintRepository.findByItensBacklogId(id).stream().filter(i -> i.isActive()).toList();
    }

    /**
     * Retrieves a list of all sprints, filtering only active sprints.
     *
     * @return A list of all active sprints.
     */
    public List<Sprint> getAllSprints() {
        return StreamSupport.stream(sprintRepository.findAll().spliterator(), false).filter(i -> i.isActive()).toList();
    }

    /**
     * Saves a new sprint.
     *
     * @param sprint The sprint to be saved.
     * @return The saved sprint.
     */
    @Override
    public Sprint save(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    /**
     * Updates an existing sprint by ID.
     *
     * @param id     The ID of the sprint to be updated.
     * @param sprint The updated sprint data.
     * @return The updated sprint.
     * @throws EntityNotFoundException If the sprint with the given ID is not found or is not active.
     */
    @Override
    public Sprint update(Long id, Sprint sprint) throws EntityNotFoundException {
        Optional<Sprint> savedSprintOptional = sprintRepository.findById(id);
        if (savedSprintOptional.isPresent()) {
            Sprint savedSprint = savedSprintOptional.get().update(sprint);
            return sprintRepository.save(savedSprint);
        } else {
            throw new EntityNotFoundException("Sprint with ID " + sprint.getId() + " was not found or is not active.");
        }
    }

    /**
     * Retrieves a sprint by ID.
     *
     * @param id The ID of the sprint to retrieve.
     * @return The retrieved sprint.
     * @throws EntityNotFoundException If the sprint with the given ID is not found or is not active.
     */
    @Override
    public Sprint findById(Long id) {
        Optional<Sprint> sprint = sprintRepository.findById(id);
        if (sprint.isPresent() && sprint.get().isActive()) {
            return sprint.get();
        } else {
            throw new EntityNotFoundException("Sprint with ID " + id + " was not found or is not active.");
        }
    }

    /**
     * Deactivates a sprint by ID.
     *
     * @param id The ID of the sprint to deactivate.
     * @return The deactivated sprint.
     * @throws EntityNotFoundException If the sprint with the given ID is not found or is not active.
     */
    @Override
    public Sprint deactivateById(Long id) {
        Optional<Sprint> sprint = sprintRepository.findById(id);
        if (sprint.isPresent() && sprint.get().isActive()) {
            sprint.get().setActive(false);
            return sprintRepository.save(sprint.get());
        } else {
            throw new EntityNotFoundException("Sprint with ID " + id + " was not found or is not active.");
        }
    }
}
