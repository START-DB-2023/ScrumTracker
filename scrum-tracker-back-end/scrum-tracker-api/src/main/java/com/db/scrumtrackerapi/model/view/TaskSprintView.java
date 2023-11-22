package com.db.scrumtrackerapi.model.view;
import java.util.Objects;

/**
 * Represents a view of a task within a sprint, providing information such as task details,
 * status, priority, and the responsible customer.
 */
public class TaskSprintView {

    /**
     * The unique identifier of the Sprint.
     */
    private Long id;

    /**
     * The item backlog associated with the task.
     */
    private String name;

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
    private String status;

    /**
     * The priority of the task.
     */
    private String priority;

    /**
     * The effort estimation for the task.
     */
    private String effortEstimation;

    /**
     * The person responsible for the task.
     */
    private CustomerView responsible;

    /**
     * Default constructor for TaskSprintView.
     */
    protected TaskSprintView() {
    }

    /**
     * Parameterized constructor to create a TaskSprintView with specific attributes.
     *
     * @param id               The unique identifier for the task.
     * @param name             The name or title of the task.
     * @param description      The detailed description of the task.
     * @param comments         Additional comments or notes related to the task.
     * @param status           The current status of the task.
     * @param priority         The priority level of the task.
     * @param effortEstimation The estimated effort required for the task.
     * @param responsible      The customer or entity responsible for the task.
     */
    public TaskSprintView(Long id, String name, String description, String comments, String status, String priority, String effortEstimation, CustomerView responsible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.status = status;
        this.priority = priority;
        this.effortEstimation = effortEstimation;
        this.responsible = responsible;
    }

    /**
     * Retrieves the unique identifier of the task.
     *
     * @return The unique identifier of the task.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of the task.
     *
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name or title of the task.
     *
     * @return The name or title of the task.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name or title of the task.
     *
     * @param name The name or title to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the detailed description of the task.
     *
     * @return The detailed description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the detailed description of the task.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves additional comments or notes related to the task.
     *
     * @return Additional comments or notes related to the task.
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets additional comments or notes related to the task.
     *
     * @param comments The comments to set.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Retrieves the current status of the task.
     *
     * @return The current status of the task.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets the current status of the task.
     *
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the priority level of the task.
     *
     * @return The priority level of the task.
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority level of the task.
     *
     * @param priority The priority to set.
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Retrieves the estimated effort required for the task.
     *
     * @return The estimated effort required for the task.
     */
    public String getEffortEstimation() {
        return this.effortEstimation;
    }

    /**
     * Sets the estimated effort required for the task.
     *
     * @param effortEstimation The effort estimation to set.
     */
    public void setEffortEstimation(String effortEstimation) {
        this.effortEstimation = effortEstimation;
    }

    /**
     * Retrieves the customer or entity responsible for the task.
     *
     * @return The customer or entity responsible for the task.
     */
    public CustomerView getResponsible() {
        return this.responsible;
    }

    /**
     * Sets the customer or entity responsible for the task.
     *
     * @param responsible The responsible customer to set.
     */
    public void setResponsible(CustomerView responsible) {
        this.responsible = responsible;
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
        if (!(o instanceof TaskSprintView)) {
            return false;
        }
        TaskSprintView taskSprintView = (TaskSprintView) o;
        return Objects.equals(id, taskSprintView.id) && Objects.equals(name, taskSprintView.name) && Objects.equals(description, taskSprintView.description) && Objects.equals(comments, taskSprintView.comments) && Objects.equals(status, taskSprintView.status) && Objects.equals(priority, taskSprintView.priority) && Objects.equals(effortEstimation, taskSprintView.effortEstimation) && Objects.equals(responsible, taskSprintView.responsible);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, comments, status, priority, effortEstimation, responsible);
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
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", comments='" + getComments() + "'" +
            ", status='" + getStatus() + "'" +
            ", priority='" + getPriority() + "'" +
            ", effortEstimation='" + getEffortEstimation() + "'" +
            ", responsible='" + getResponsible() + "'" +
            "}";
    }
}
