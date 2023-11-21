package com.db.scrumtrackerapi.model.dto;
import java.util.List;

import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.ProductBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class ItemBacklogDTO{

    /**
     * The status of the backlog item.
     */
    @NotNull(message = "Null Field.")
    private Status status;

    /**
     * The priority of the backlog item.
     */
    @NotNull(message = "Null Field.")
    private Priority priority;

    /**
     * The name of the backlog item.
     */
    @NotNull(message = "Null Field.")
    private String name;

    /**
     * The criteria for acceptance of the backlog item.
     */
    @NotNull(message = "Null Field.")
    private String criteriaAcceptance;

    /**
     * The effort estimation for the backlog item.
     */
    @NotNull(message = "Null Field.")
    private String effortEstimation;

    /**
     * List of sprints associated with the backlog item.
     */
    private List<Sprint> sprints;

    /**
     * The description of the backlog item.
     */
    private String description;

    /**
     * The product backlog associated with the backlog item.
     */
    private ProductBacklog productBacklog;

    /**
     * Converts this DTO to an actual ItemBacklog entity.
     *
     * @return The ItemBacklog entity created from this DTO.
     */
	public ItemBacklog toItemBacklog() {
		return new ItemBacklog(status,priority,name,criteriaAcceptance,effortEstimation,sprints,description,productBacklog);
	}
    
    /**
     * Protected empty constructor for use by persistence frameworks.
     */
    protected ItemBacklogDTO() {
    }

    /**
     * Parameterized constructor for ItemBacklogDTO.
     *
     * @param status            The status of the backlog item.
     * @param priority          The priority of the backlog item.
     * @param name              The name of the backlog item.
     * @param criteriaAcceptance The criteria for acceptance of the backlog item.
     * @param effortEstimation  The effort estimation for the backlog item.
     * @param sprints           List of sprints associated with the backlog item.
     * @param description       The description of the backlog item.
     * @param productBacklog    The product backlog associated with the backlog item.
     */
    public ItemBacklogDTO(Status status, Priority priority, String name, String criteriaAcceptance, String effortEstimation, List<Sprint> sprints, String description, ProductBacklog productBacklog) {
        this.status = status;
        this.priority = priority;
        this.name = name;
        this.criteriaAcceptance = criteriaAcceptance;
        this.effortEstimation = effortEstimation;
        this.sprints = sprints;
        this.description = description;
        this.productBacklog = productBacklog;
    }

    /**
     * Gets the status of the backlog item.
     *
     * @return The status of the backlog item.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the backlog item.
     *
     * @param status The status to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the priority of the backlog item.
     *
     * @return The priority of the backlog item.
     */
    public Priority getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority of the backlog item.
     *
     * @param priority The priority to set.
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Gets the name of the backlog item.
     *
     * @return The name of the backlog item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the backlog item.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the criteria for acceptance of the backlog item.
     *
     * @return The criteria for acceptance of the backlog item.
     */
    public String getCriteriaAcceptance() {
        return this.criteriaAcceptance;
    }

    /**
     * Sets the criteria for acceptance of the backlog item.
     *
     * @param criteriaAcceptance The criteria for acceptance to set.
     */
    public void setCriteriaAcceptance(String criteriaAcceptance) {
        this.criteriaAcceptance = criteriaAcceptance;
    }

    /**
     * Gets the effort estimation for the backlog item.
     *
     * @return The effort estimation for the backlog item.
     */
    public String getEffortEstimation() {
        return this.effortEstimation;
    }

    /**
     * Sets the effort estimation for the backlog item.
     *
     * @param effortEstimation The effort estimation to set.
     */
    public void setEffortEstimation(String effortEstimation) {
        this.effortEstimation = effortEstimation;
    }

    /**
     * Gets the sprint associated with the backlog item.
     *
     * @return The sprint associated with the backlog item.
     */
    public List<Sprint> getSprints() {
        return this.sprints;
    }

    /**
     * Sets the sprint associated with the backlog item.
     *
     * @param sprint The sprint to set.
     */
    public void setSprints(List<Sprint> sprint) {
        this.sprints = sprint;
    }

    /**
     * Gets the description of the backlog item.
     *
     * @return The description of the backlog item.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the backlog item.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the product backlog associated with the backlog item.
     *
     * @return The product backlog associated with the backlog item.
     */
    public ProductBacklog getProductBacklog() {
        return this.productBacklog;
    }

    /**
     * Sets the product backlog associated with the backlog item.
     *
     * @param productBacklog The product backlog to set.
     */
    public void setProductBacklog(ProductBacklog productBacklog) {
        this.productBacklog = productBacklog;
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
        if (!(o instanceof ItemBacklog)) return false;
        ItemBacklog itemBacklog = (ItemBacklog) o;
        return Objects.equals(status, itemBacklog.getStatus()) &&
                Objects.equals(priority, itemBacklog.getPriority()) &&
                Objects.equals(name, itemBacklog.getName()) &&
                Objects.equals(criteriaAcceptance, itemBacklog.getCriteriaAcceptance()) &&
                Objects.equals(effortEstimation, itemBacklog.getEffortEstimation()) &&
                Objects.equals(Arrays.hashCode(sprints.stream().map(i -> i.getId()).toArray()), Arrays.hashCode(itemBacklog.getSprints().stream().map(i -> i.getId()).toArray())) &&
                Objects.equals(description, itemBacklog.getDescription()) &&
                Objects.equals(productBacklog.getId(), itemBacklog.getProductBacklog().getId());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(status, priority, name, criteriaAcceptance, effortEstimation, sprints, description, productBacklog.getId());
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
                " status='" + getStatus() + "'" +
                ", priority='" + getPriority() + "'" +
                ", name='" + getName() + "'" +
                ", criteriaAcceptance='" + getCriteriaAcceptance() + "'" +
                ", effortEstimation='" + getEffortEstimation() + "'" +
                ", sprintIds='" + getSprints().stream().map(i -> i.getId()) + "'" +
                ", description='" + getDescription() + "'" +
                ", productBacklogId='" + getProductBacklog().getId() + "'" +
                "}";
    }
}