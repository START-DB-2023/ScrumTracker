package com.db.scrumtrackerapi.model.view;

import java.util.List;
import java.util.Objects;


/**
 * Represents a detailed view of a Sprint, providing information about its goals, associated tasks, and related backlog items.
 */
public class DetailedSprintView {
    
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
     * The backlog items associated with the Sprint.
     */
    private List<ItemBacklogView> itemBacklogViews;

    /**
     * Default constructor for DetailedSprintView.
     */
    protected DetailedSprintView() {
    }

    /**
     * Constructor to initialize DetailedSprintView with specific values.
     *
     * @param id The unique identifier of the Sprint.
     * @param sprintGoals The goals of the Sprint.
     * @param tasksSprints The tasks associated with the Sprint.
     * @param itemBacklogViews The backlog items associated with the Sprint.
     */
    public DetailedSprintView(Long id, String sprintGoals, List<TaskSprintView> tasksSprints, List<ItemBacklogView> itemBacklogViews) {
        this.id = id;
        this.sprintGoals = sprintGoals;
        this.tasksSprints = tasksSprints;
        this.itemBacklogViews = itemBacklogViews;
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
     * Retrieves the backlog items associated with the Sprint.
     *
     * @return The backlog items associated with the Sprint.
     */
    public List<ItemBacklogView> getItemBacklogViews() {
        return this.itemBacklogViews;
    }

    /**
     * Sets the backlog items associated with the Sprint.
     *
     * @param itemBacklogViews The backlog items associated with the Sprint.
     */
    public void setItemBacklogViews(List<ItemBacklogView> itemBacklogViews) {
        this.itemBacklogViews = itemBacklogViews;
    }

    /**
     * Fluent method to set the id attribute.
     *
     * @param id The unique identifier of the Sprint.
     * @return The updated DetailedSprintView instance.
     */
    public DetailedSprintView id(Long id) {
        setId(id);
        return this;
    }

    /**
     * Fluent method to set the sprintGoals attribute.
     *
     * @param sprintGoals The goals of the Sprint.
     * @return The updated DetailedSprintView instance.
     */
    public DetailedSprintView sprintGoals(String sprintGoals) {
        setSprintGoals(sprintGoals);
        return this;
    }

    /**
     * Fluent method to set the tasksSprints attribute.
     *
     * @param tasksSprints The tasks associated with the Sprint.
     * @return The updated DetailedSprintView instance.
     */
    public DetailedSprintView tasksSprints(List<TaskSprintView> tasksSprints) {
        setTasksSprints(tasksSprints);
        return this;
    }

    /**
     * Fluent method to set the itemBacklogViews attribute.
     *
     * @param itemBacklogViews The backlog items associated with the Sprint.
     * @return The updated DetailedSprintView instance.
     */
    public DetailedSprintView itemBacklogViews(List<ItemBacklogView> itemBacklogViews) {
        setItemBacklogViews(itemBacklogViews);
        return this;
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
        if (!(o instanceof DetailedSprintView)) {
            return false;
        }
        DetailedSprintView detailedSprintView = (DetailedSprintView) o;
        return Objects.equals(id, detailedSprintView.id) && Objects.equals(sprintGoals, detailedSprintView.sprintGoals) && Objects.equals(tasksSprints, detailedSprintView.tasksSprints) && Objects.equals(itemBacklogViews, detailedSprintView.itemBacklogViews);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, sprintGoals, tasksSprints, itemBacklogViews);
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
            ", itemBacklogViews='" + getItemBacklogViews() + "'" +
            "}";
    }
}
