package com.db.scrumtrackerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.scrumtrackerapi.model.Sprint;

/**
 * Repository interface for {@link Sprint} entities.
 */
@Repository
public interface SprintRepository extends CrudRepository<Sprint, Long> {

    /**
     * Retrieves a list of sprints by item backlog ID.
     *
     * @param id The ID of the associated item backlog.
     * @return The list of sprints associated with the given item backlog ID.
     */
    @Query("SELECT s FROM Sprint s  JOIN s.itensBacklog i WHERE i.id = :itensBacklogId")
    List<Sprint> findByItensBacklogId(@Param("itensBacklogId") Long id);

}