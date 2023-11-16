package com.db.scrumtrackerapi.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * A base class for entities providing a common field for unique identification (ID).
 * 
 * This is not an entity on its own but will be mapped to the entities that inherit from it.
 */
@MappedSuperclass
public class BaseEntity {
    
    /**
     * The unique identifier for the entity.
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Gets the unique identifier of the entity.
     *
     * @return The ID of the entity.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of the entity.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

}
