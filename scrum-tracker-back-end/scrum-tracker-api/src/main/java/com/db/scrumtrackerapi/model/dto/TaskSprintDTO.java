package com.db.scrumtrackerapi.model.dto;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.TaskSprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;
import java.util.Objects;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) representing product information.
 */
public class TaskSprintDTO{

    /**
     * The name of the task.
     */
    @NotBlank(message = "Blank Field.")
    private String name;

    /**
     * The item backlog associated with the task.
     */
    private ItemBacklog itemBacklog;

    /**
     * The description of the task.
     */
    private String description;

    /**
     * Comments related to the task.
     */
    private String comments;

    /**
     * The status of the task.
     */
    @NotNull(message = "Null Field.")
    private Status status;

    /**
     * The priority of the task.
     */
    @NotNull(message = "Null Field.")
    private Priority priority;

    /**
     * The effort estimation for the task.
     */
    private String effortEstimation;

    /**
     * The person responsible for the task.
     */
    private Customer responsible;

    /**
     * The sprint to which the task belongs.
     */
    private Sprint sprint;

    /**
     * Converts the DTO object to a TaskSprint entity.
     *
     * @return A Task entity created from the DTO.
     */
    public TaskSprint toTaskSprint(){
        return new TaskSprint(name,itemBacklog,description,comments,status,priority,effortEstimation,responsible,sprint);
    }

    /**
     * Default constructor. Creates an instance of TaskSprint.
     */
    protected TaskSprintDTO() {
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
    public TaskSprintDTO(String name, ItemBacklog itemBacklog, String description, String comments, Status status, Priority priority, String effortEstimation, Customer responsible, Sprint sprint) {
        this.name = name;
        this.itemBacklog = itemBacklog;
        this.description = description;
        this.comments = comments;
        this.status = status;
        this.priority = priority;
        this.effortEstimation = effortEstimation;
        this.responsible = responsible;
        this.sprint = sprint;
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
        return Objects.equals(name, taskSprint.getName()) && Objects.equals(itemBacklog.getId(), taskSprint.getItemBacklog().getId()) && Objects.equals(description, taskSprint.getDescription()) && Objects.equals(comments, taskSprint.getComments()) && Objects.equals(status, taskSprint.getStatus()) && Objects.equals(priority, taskSprint.getPriority()) && Objects.equals(effortEstimation, taskSprint.getEffortEstimation()) && Objects.equals(responsible, taskSprint.getResponsible()) && Objects.equals(sprint.getId(), taskSprint.getSprint().getId());
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