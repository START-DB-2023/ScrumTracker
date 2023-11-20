package com.db.scrumtrackerapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
     * Indicates whether the entity is active or not.
     */
    @Column(name = "active")
    private Boolean active;

    
    /*
     * The timestamp of the last modification
     */
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

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

    /**
     * Checks whether the entity is active.
     *
     * @return {@code true} if the entity is active, {@code false} otherwise.
     */
     public Boolean isActive() {
        return this.active;
    } 


    /**
     * Retrieves the active status of the entity.
     *
     * @return {@code true} if the entity is active, {@code false} otherwise.
     */
    public Boolean getActive() {
        return this.active;
    }


    /**
     * Sets the active status of the entity.
     *
     * @param active The value to set as the active status. {@code true} if the entity is active, {@code false} otherwise.
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    /**
     * Retrieves the timestamp of the last entity modification.
     *
     * @return the timestamp of the last modification.
     */
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Sets the timestamp of the last modification as now.
     */
    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    
}
