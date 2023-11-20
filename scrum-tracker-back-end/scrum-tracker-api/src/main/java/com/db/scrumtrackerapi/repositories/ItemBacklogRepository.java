package com.db.scrumtrackerapi.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.scrumtrackerapi.model.ItemBacklog;
 
/**
 * Repository interface for {@link ItemBacklog} entities.
 */
@Repository
public interface ItemBacklogRepository extends CrudRepository<ItemBacklog, Long> {

    /**
     * Retrieves a list of item backlogs by product backlog ID.
     *
     * @param id The ID of the associated product backlog.
     * @return The list of item backlogs associated with the given product backlog ID.
     */
    @Query("SELECT i FROM ItemBacklog i  WHERE i.productBacklog.id = :productBacklogId")
    List<ItemBacklog> findByProductBacklogId(@Param("productBacklogId") Long id);

    /**
     * Retrieves a list of item backlogs by sprint ID.
     *
     * @param id The ID of the associated sprint.
     * @return The list of item backlogs associated with the given sprint ID.
     */
    @Query("SELECT i FROM ItemBacklog i JOIN i.sprints s WHERE s.id = :sprintId")
    List<ItemBacklog> findBySprintId(@Param("sprintId") Long id);    
}