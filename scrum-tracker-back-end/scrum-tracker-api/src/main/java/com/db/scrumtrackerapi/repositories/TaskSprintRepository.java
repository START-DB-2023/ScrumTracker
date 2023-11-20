package com.db.scrumtrackerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.scrumtrackerapi.model.TaskSprint;

/**
 * Repository interface for {@link TaskSprint} entities.
 */
@Repository
public interface TaskSprintRepository extends CrudRepository<TaskSprint, Long> {

    /**
     * Retrieves a list of task sprints by sprint ID.
     *
     * @param id The ID of the associated sprint.
     * @return The list of task sprints associated with the given sprint ID.
     */
    @Query("SELECT t FROM TaskSprint t JOIN t.sprint s WHERE s.id = :sprint")
    List<TaskSprint> findBySprintId(@Param("sprint") Long id);
}