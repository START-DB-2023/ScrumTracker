package com.db.scrumtrackerapi.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a sprint in the Scrum Tracker system.
 * A sprint has sprint goals, a list of backlog items, and a list of tasks associated with it.
 */
@Entity
@Table(name = "sprints")
public class Sprint extends BaseEntity {

    /**
     * The goals of the sprint.
     */
    @Column(name = "sprint_goals")
    private String sprintGoals;

    /**
     * The backlog items associated with the sprint.
     */
    @ManyToMany
    @JoinTable(
        name = "sprint_item_backlog",
        joinColumns = @JoinColumn(name = "sprint_id"),
        inverseJoinColumns = @JoinColumn(name = "item_backlog_id")
    )
    private List<ItemBacklog> itensBacklog;

    /**
     * The tasks associated with the sprint.
     */
    @OneToMany(mappedBy = "sprint")
    private List<TaskSprint> tasksSprints;

    public Sprint updateSprint(Sprint sprint) {
        this.sprintGoals = sprint.getSprintGoals();
        this.itensBacklog = sprint.getItensBacklog();
        this.tasksSprints = sprint.getTasksSprints(); 
        return this; 
    }

    /**
     * Default constructor, should be used only by JPA.
     */
    protected Sprint() {
    }

    /**
     * Creates a new sprint with specified attributes.
     *
     * @param sprintGoals   The goals of the sprint.
     * @param itensBacklog  The backlog items associated with the sprint.
     * @param tasksSprints  The tasks associated with the sprint.
     */
    public Sprint(String sprintGoals, List<ItemBacklog> itensBacklog, List<TaskSprint> tasksSprints) {
        this.sprintGoals = sprintGoals;
        this.itensBacklog = itensBacklog;
        this.tasksSprints = tasksSprints;
        super.setActive(true);
        super.setTimestamp();
    }

    /**
     * Gets the goals of the sprint.
     *
     * @return The goals of the sprint.
     */
    public String getSprintGoals() {
        return this.sprintGoals;
    }

    /**
     * Sets the goals of the sprint.
     *
     * @param sprintGoals The goals to set.
     */
    public void setSprintGoals(String sprintGoals) {
        this.sprintGoals = sprintGoals;
    }

    /**
     * Gets the backlog items associated with the sprint.
     *
     * @return The backlog items associated with the sprint.
     */
    public List<ItemBacklog> getItensBacklog() {
        return this.itensBacklog;
    }

    /**
     * Sets the backlog items associated with the sprint.
     *
     * @param itensBacklog The backlog items to set.
     */
    public void setItensBacklog(List<ItemBacklog> itensBacklog) {
        this.itensBacklog = itensBacklog;
    }

    /**
     * Gets the tasks associated with the sprint.
     *
     * @return The tasks associated with the sprint.
     */
    public List<TaskSprint> getTasksSprints() {
        return this.tasksSprints;
    }

    /**
     * Sets the tasks associated with the sprint.
     *
     * @param tasksSprints The tasks to set.
     */
    public void setTasksSprints(List<TaskSprint> tasksSprints) {
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
        if (o == this) return true;
        if (!(o instanceof Sprint)) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(sprintGoals, sprint.sprintGoals) &&
                Objects.equals(Arrays.hashCode(itensBacklog.stream().map(i -> i.getId()).toArray()), Arrays.hashCode(sprint.getItensBacklog().stream().map(i -> i.getId()).toArray())) &&
                Objects.equals(Arrays.hashCode(tasksSprints.stream().map(i -> i.getId()).toArray()), Arrays.hashCode(sprint.getTasksSprints().stream().map(i -> i.getId()).toArray()));
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sprintGoals, Arrays.hashCode(itensBacklog.stream().map(i -> i.getId()).toArray()),  Arrays.hashCode(tasksSprints.stream().map(i -> i.getId()).toArray()));
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
                " sprintGoals='" + getSprintGoals() + "'" +
                ", itemBacklogIds='" + getItensBacklog().stream().map(i -> i.getId()) + "'" +
                ", taskSprintsIds='" + getTasksSprints().stream().map(i -> i.getId()) + "'" +
                "}";
    }
}

