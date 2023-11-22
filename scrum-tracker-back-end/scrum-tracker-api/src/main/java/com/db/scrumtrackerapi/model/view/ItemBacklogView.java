package com.db.scrumtrackerapi.model.view;

import java.util.List;
import java.util.Objects;

/**
 * Represents a view of a backlog item.
 */
public class ItemBacklogView {
    
    /**
     * The unique identifier of the backlog item.
     */
    private Long id;

    /**
     * The status of the backlog item.
     */
    private String status;

    /**
     * The priority of the backlog item.
     */
    private String priority;

    /**
     * The name of the backlog item.
     */
    private String name;

    /**
     * The criteria for acceptance of the backlog item.
     */
    private String criteriaAcceptance;

    /**
     * The effort estimation for the backlog item.
     */
    private String effortEstimation;

    /**
     * List of sprints associated with the backlog item.
     */
    private List<SprintView> sprintViews;

    /**
     * The user history of the backlog item.
     */
    private String userHistory;

    /**
     * Default constructor.
     */
    protected ItemBacklogView() {
    }

    /**
     * Parameterized constructor to initialize the backlog item view.
     * 
     * @param id The unique identifier of the backlog item.
     * @param status The status of the backlog item.
     * @param priority The priority of the backlog item.
     * @param name The name of the backlog item.
     * @param criteriaAcceptance The criteria for acceptance of the backlog item.
     * @param effortEstimation The effort estimation for the backlog item.
     * @param sprintViews List of sprints associated with the backlog item.
     * @param userHistory The user history of the backlog item.
     */
    public ItemBacklogView(Long id, String status, String priority, String name, String criteriaAcceptance, String effortEstimation, List<SprintView> sprintViews, String userHistory) {
        this.id = id;
        this.status = status;
        this.priority = priority;
        this.name = name;
        this.criteriaAcceptance = criteriaAcceptance;
        this.effortEstimation = effortEstimation;
        this.sprintViews = sprintViews;
        this.userHistory = userHistory;
    }

    /**
     * Getter for the unique identifier of the backlog item.
     * 
     * @return The unique identifier of the backlog item.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for the unique identifier of the backlog item.
     * 
     * @param id The unique identifier of the backlog item.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for the status of the backlog item.
     * 
     * @return The status of the backlog item.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for the status of the backlog item.
     * 
     * @param status The status of the backlog item.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for the priority of the backlog item.
     * 
     * @return The priority of the backlog item.
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * Setter for the priority of the backlog item.
     * 
     * @param priority The priority of the backlog item.
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Getter for the name of the backlog item.
     * 
     * @return The name of the backlog item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the name of the backlog item.
     * 
     * @param name The name of the backlog item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the criteria for acceptance of the backlog item.
     * 
     * @return The criteria for acceptance of the backlog item.
     */
    public String getCriteriaAcceptance() {
        return this.criteriaAcceptance;
    }

    /**
     * Setter for the criteria for acceptance of the backlog item.
     * 
     * @param criteriaAcceptance The criteria for acceptance of the backlog item.
     */
    public void setCriteriaAcceptance(String criteriaAcceptance) {
        this.criteriaAcceptance = criteriaAcceptance;
    }

    /**
     * Getter for the effort estimation for the backlog item.
     * 
     * @return The effort estimation for the backlog item.
     */
    public String getEffortEstimation() {
        return this.effortEstimation;
    }

    /**
     * Setter for the effort estimation for the backlog item.
     * 
     * @param effortEstimation The effort estimation for the backlog item.
     */
    public void setEffortEstimation(String effortEstimation) {
        this.effortEstimation = effortEstimation;
    }

    /**
     * Getter for the list of sprints associated with the backlog item.
     * 
     * @return List of sprints associated with the backlog item.
     */
    public List<SprintView> getSprintViews() {
        return this.sprintViews;
    }

    /**
     * Setter for the list of sprints associated with the backlog item.
     * 
     * @param sprintViews List of sprints associated with the backlog item.
     */
    public void setSprintViews(List<SprintView> sprintViews) {
        this.sprintViews = sprintViews;
    }

    /**
     * Getter for the user history of the backlog item.
     * 
     * @return The user history of the backlog item.
     */
    public String getUserHistory() {
        return this.userHistory;
    }

    /**
     * Setter for the user history of the backlog item.
     * 
     * @param userHistory The user history of the backlog item.
     */
    public void setUserHistory(String userHistory) {
        this.userHistory = userHistory;
    }

    /**
     * Overrides the equals method to check for equality based on the attributes.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemBacklogView)) {
            return false;
        }
        ItemBacklogView itemBacklogView = (ItemBacklogView) o;
        return Objects.equals(id, itemBacklogView.id) && Objects.equals(status, itemBacklogView.status) && Objects.equals(priority, itemBacklogView.priority) && Objects.equals(name, itemBacklogView.name) && Objects.equals(criteriaAcceptance, itemBacklogView.criteriaAcceptance) && Objects.equals(effortEstimation, itemBacklogView.effortEstimation) && Objects.equals(sprintViews, itemBacklogView.sprintViews) && Objects.equals(userHistory, itemBacklogView.userHistory);
    }

    /**
     * Overrides the hashCode method to generate a hash code based on the attributes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, status, priority, name, criteriaAcceptance, effortEstimation, sprintViews, userHistory);
    }

    /**
     * Overrides the toString method to provide a string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", priority='" + getPriority() + "'" +
            ", name='" + getName() + "'" +
            ", criteriaAcceptance='" + getCriteriaAcceptance() + "'" +
            ", effortEstimation='" + getEffortEstimation() + "'" +
            ", sprintViews='" + getSprintViews() + "'" +
            ", userHistory='" + getUserHistory() + "'" +
            "}";
    }
}
