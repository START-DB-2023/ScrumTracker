package com.db.scrumtrackerapi.model.dto;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.TaskSprint;

public class SprintDTO{

    /**
     * The goals of the sprint.
     */
    private String sprintGoals;

    /**
     * The backlog items associated with the sprint.
     */
    private List<ItemBacklog> itensBacklog;

    /**
     * The tasks associated with the sprint.
     */
    private List<TaskSprint> tasksSprints;

    /**
     * Converts the DTO object to a Sprint entity.
     *
     * @return A Sprint entity created from the DTO.
     */
    public Sprint toSprint(){
        return new Sprint(sprintGoals, itensBacklog, tasksSprints);
    }

    /**
     * Default constructor, should be used only by JPA.
     */
    protected SprintDTO() {
    }

    /**
     * Creates a new sprint with specified attributes.
     *
     * @param sprintGoals   The goals of the sprint.
     * @param itensBacklog  The backlog items associated with the sprint.
     * @param tasksSprints  The tasks associated with the sprint.
     */
    public SprintDTO(String sprintGoals, List<ItemBacklog> itensBacklog, List<TaskSprint> tasksSprints) {
        this.sprintGoals = sprintGoals;
        this.itensBacklog = itensBacklog;
        this.tasksSprints = tasksSprints;
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
        return Objects.equals(sprintGoals, sprint.getSprintGoals()) &&
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