package com.db.scrumtrackerapi.model.view;

import java.util.List;
import java.util.Objects;


/**
 * Represents a view of a Sprint, providing information about its goals and associated tasks.
 */
public class SprintView {
    
    /**
     * The unique identifier of the Sprint.
     */
    private Long id;

    /**
     * The goals of the Sprint.
     */
    private String sprintGoals;

    /**
     * The tasks associated with the Sprint.
     */
    private List<TaskSprintView> tasksSprints;


    /**
     * Default constructor for SprintView.
     */
    protected SprintView() {
    }

    /**
     * Constructor to initialize SprintView with specific values.
     *
     * @param id The unique identifier of the Sprint.
     * @param sprintGoals The goals of the Sprint.
     * @param tasksSprints The tasks associated with the Sprint.
     */
    public SprintView(Long id, String sprintGoals, List<TaskSprintView> tasksSprints) {
        this.id = id;
        this.sprintGoals = sprintGoals;
        this.tasksSprints = tasksSprints;
    }

    /**
     * Retrieves the unique identifier of the Sprint.
     *
     * @return The unique identifier of the Sprint.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of the Sprint.
     *
     * @param id The unique identifier of the Sprint.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the goals of the Sprint.
     *
     * @return The goals of the Sprint.
     */
    public String getSprintGoals() {
        return this.sprintGoals;
    }

    /**
     * Sets the goals of the Sprint.
     *
     * @param sprintGoals The goals of the Sprint.
     */
    public void setSprintGoals(String sprintGoals) {
        this.sprintGoals = sprintGoals;
    }

    /**
     * Retrieves the tasks associated with the Sprint.
     *
     * @return The tasks associated with the Sprint.
     */
    public List<TaskSprintView> getTasksSprints() {
        return this.tasksSprints;
    }

    /**
     * Sets the tasks associated with the Sprint.
     *
     * @param tasksSprints The tasks associated with the Sprint.
     */
    public void setTasksSprints(List<TaskSprintView> tasksSprints) {
        this.tasksSprints = tasksSprints;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SprintView)) {
            return false;
        }
        SprintView sprintView = (SprintView) o;
        return Objects.equals(id, sprintView.id) && Objects.equals(sprintGoals, sprintView.sprintGoals) && Objects.equals(tasksSprints, sprintView.tasksSprints);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, sprintGoals, tasksSprints);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", sprintGoals='" + getSprintGoals() + "'" +
            ", tasksSprints='" + getTasksSprints() + "'" +
            "}";
    }
}

