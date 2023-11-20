package com.db.scrumtrackerapi.model;

import java.util.Objects;

import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents a task in a Sprint of the Scrum Tracker system.
 * A task in a Sprint contains information such as name, description, comments, status, priority,
 * effort estimation, responsible person, associated item backlog, and the sprint to which it belongs.
 */
@Entity
@Table(name = "tasks_sprint")
public class TaskSprint extends BaseEntity {

    /**
     * The name of the task.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The item backlog associated with the task.
     */
    @ManyToOne
    @JoinColumn(name = "item_backlog_id")
    private ItemBacklog itemBacklog;

    /**
     * The description of the task.
     */
    @Column(name = "description", nullable = true)
    private String description;

    /**
     * Comments related to the task.
     */
    @Column(name = "comments", nullable = true)
    private String comments;

    /**
     * The status of the task.
     */
    @Column(name = "status", nullable = false)
    private Status status;

    /**
     * The priority of the task.
     */
    @Column(name = "priority", nullable = false)
    private Priority priority;

    /**
     * The effort estimation for the task.
     */
    @Column(name = "effort_estimation", nullable = true)
    private String effortEstimation;

    /**
     * The person responsible for the task.
     */
    @OneToOne
    @JoinColumn(name = "responsible_id")
    private Customer responsible;

    /**
     * The sprint to which the task belongs.
     */
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    public TaskSprint updateTaskSprint(TaskSprint taskSprint) {
        this.name = taskSprint.getName();
        this.itemBacklog = taskSprint.getItemBacklog();
        this.description = taskSprint.getDescription();
        this.comments = taskSprint.getComments();
        this.status = taskSprint.getStatus();
        this.priority = taskSprint.getPriority();
        this.effortEstimation = taskSprint.getEffortEstimation();
        this.responsible = taskSprint.getResponsible();
        this.sprint = taskSprint.getSprint();
        return this;
    }

    /**
     * Default constructor. Creates an instance of TaskSprint.
     */
    protected TaskSprint() {
    }

    /**
     * Creates an instance of TaskSprint with specified attributes.
     *
     * @param name            The name of the task.
     * @param itemBacklog     The item backlog associated with the task.
     * @param description     The description of the task.
     * @param comments        Comments related to the task.
     * @param status          The status of the task.
     * @param priority        The priority of the task.
     * @param effortEstimation The effort estimation for the task.
     * @param responsible     The person responsible for the task.
     * @param sprint          The sprint to which the task belongs.
     */
    public TaskSprint(String name, ItemBacklog itemBacklog, String description, String comments, Status status, Priority priority, String effortEstimation, Customer responsible, Sprint sprint) {
        this.name = name;
        this.itemBacklog = itemBacklog;
        this.description = description;
        this.comments = comments;
        this.status = status;
        this.priority = priority;
        this.effortEstimation = effortEstimation;
        this.responsible = responsible;
        this.sprint = sprint;
        super.setActive(true);
        super.setTimestamp();
    }

    /**
     * Gets the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the task.
     *
     * @param name The name of the task.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the item backlog associated with the task.
     *
     * @return The item backlog associated with the task.
     */
    public ItemBacklog getItemBacklog() {
        return this.itemBacklog;
    }

    /**
     * Sets the item backlog associated with the task.
     *
     * @param itemBacklog The item backlog associated with the task.
     */
    public void setItemBacklog(ItemBacklog itemBacklog) {
        this.itemBacklog = itemBacklog;
    }

    /**
     * Gets the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The description of the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets comments related to the task.
     *
     * @return Comments related to the task.
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets comments related to the task.
     *
     * @param comments Comments related to the task.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the status of the task.
     *
     * @return The status of the task.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the task.
     *
     * @param status The status of the task.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the priority of the task.
     *
     * @return The priority of the task.
     */
    public Priority getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority of the task.
     *
     * @param priority The priority of the task.
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Gets the effort estimation for the task.
     *
     * @return The effort estimation for the task.
     */
    public String getEffortEstimation() {
        return this.effortEstimation;
    }

    /**
     * Sets the effort estimation for the task.
     *
     * @param effortEstimation The effort estimation for the task.
     */
    public void setEffortEstimation(String effortEstimation) {
        this.effortEstimation = effortEstimation;
    }

    /**
     * Gets the person responsible for the task.
     *
     * @return The person responsible for the task.
     */
    public Customer getResponsible() {
        return this.responsible;
    }

    /**
     * Sets the person responsible for the task.
     *
     * @param responsible The person responsible for the task.
     */
    public void setResponsible(Customer responsible) {
        this.responsible = responsible;
    }

    /**
     * Gets the sprint to which the task belongs.
     *
     * @return The sprint to which the task belongs.
     */
    public Sprint getSprint() {
        return this.sprint;
    }

    /**
     * Sets the sprint to which the task belongs.
     *
     * @param sprint The sprint to which the task belongs.
     */
    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    /**
     * Checks whether two TaskSprint objects are equal.
     *
     * @param o The object to compare.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskSprint)) {
            return false;
        }
        TaskSprint taskSprint = (TaskSprint) o;
        return Objects.equals(name, taskSprint.name) && Objects.equals(itemBacklog.getId(), taskSprint.itemBacklog.getId()) && Objects.equals(description, taskSprint.description) && Objects.equals(comments, taskSprint.comments) && Objects.equals(status, taskSprint.status) && Objects.equals(priority, taskSprint.priority) && Objects.equals(effortEstimation, taskSprint.effortEstimation) && Objects.equals(responsible, taskSprint.responsible) && Objects.equals(sprint.getId(), taskSprint.sprint.getId());
    }

    /**
     * Generates a hash code for the TaskSprint object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, itemBacklog.getId(), description, comments, status, priority, effortEstimation, responsible, sprint.getId());
    }

    /**
     * Returns a string representation of the TaskSprint object.
     *
     * @return A string representation.
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", itemBacklogId='" + getItemBacklog().getId() + "'" +
            ", description='" + getDescription() + "'" +
            ", comments='" + getComments() + "'" +
            ", status='" + getStatus() + "'" +
            ", priority='" + getPriority() + "'" +
            ", effortEstimation='" + getEffortEstimation() + "'" +
            ", responsible='" + getResponsible() + "'" +
            ", sprintId='" + getSprint().getId() + "'" +
            "}";
    }
}
