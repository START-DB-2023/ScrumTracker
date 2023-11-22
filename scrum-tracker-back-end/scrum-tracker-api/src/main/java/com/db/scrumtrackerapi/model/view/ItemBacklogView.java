package com.db.scrumtrackerapi.model.view;

import java.util.List;
import java.util.Objects;

public class ItemBacklogView {
    
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
     * The description of the backlog item.
     */
    private String description;


    protected ItemBacklogView() {
    }

    public ItemBacklogView(Long id, String status, String priority, String name, String criteriaAcceptance, String effortEstimation, List<SprintView> sprintViews, String description) {
        this.id = id;
        this.status = status;
        this.priority = priority;
        this.name = name;
        this.criteriaAcceptance = criteriaAcceptance;
        this.effortEstimation = effortEstimation;
        this.sprintViews = sprintViews;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCriteriaAcceptance() {
        return this.criteriaAcceptance;
    }

    public void setCriteriaAcceptance(String criteriaAcceptance) {
        this.criteriaAcceptance = criteriaAcceptance;
    }

    public String getEffortEstimation() {
        return this.effortEstimation;
    }

    public void setEffortEstimation(String effortEstimation) {
        this.effortEstimation = effortEstimation;
    }

    public List<SprintView> getSprintViews() {
        return this.sprintViews;
    }

    public void setSprintViews(List<SprintView> sprintViews) {
        this.sprintViews = sprintViews;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemBacklogView id(Long id) {
        setId(id);
        return this;
    }

    public ItemBacklogView status(String status) {
        setStatus(status);
        return this;
    }

    public ItemBacklogView priority(String priority) {
        setPriority(priority);
        return this;
    }

    public ItemBacklogView name(String name) {
        setName(name);
        return this;
    }

    public ItemBacklogView criteriaAcceptance(String criteriaAcceptance) {
        setCriteriaAcceptance(criteriaAcceptance);
        return this;
    }

    public ItemBacklogView effortEstimation(String effortEstimation) {
        setEffortEstimation(effortEstimation);
        return this;
    }

    public ItemBacklogView sprintViews(List<SprintView> sprintViews) {
        setSprintViews(sprintViews);
        return this;
    }

    public ItemBacklogView description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemBacklogView)) {
            return false;
        }
        ItemBacklogView itemBacklogView = (ItemBacklogView) o;
        return Objects.equals(id, itemBacklogView.id) && Objects.equals(status, itemBacklogView.status) && Objects.equals(priority, itemBacklogView.priority) && Objects.equals(name, itemBacklogView.name) && Objects.equals(criteriaAcceptance, itemBacklogView.criteriaAcceptance) && Objects.equals(effortEstimation, itemBacklogView.effortEstimation) && Objects.equals(sprintViews, itemBacklogView.sprintViews) && Objects.equals(description, itemBacklogView.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, priority, name, criteriaAcceptance, effortEstimation, sprintViews, description);
    }

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
            ", description='" + getDescription() + "'" +
            "}";
    }
    

}
