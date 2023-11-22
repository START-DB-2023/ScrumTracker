package com.db.scrumtrackerapi.model.view;

import java.util.List;
import java.util.Objects;

/**
 * Represents a view of a product backlog, including its unique identifier and a list of associated item backlogs.
 */
public class ProductBacklogView {

    /**
     * The unique identifier of the product backlog.
     */
    private Long id;

    /**
     * The list of item backlogs associated with the product backlog.
     */
    private List<ItemBacklogView> itensBacklog;

    /**
     * Default constructor for use by persistence frameworks.
     */
    protected ProductBacklogView() {
    }

    /**
     * Creates a ProductBacklogView with the specified identifier and list of item backlogs.
     *
     * @param id           The unique identifier of the product backlog.
     * @param itensBacklog The list of item backlogs associated with the product backlog.
     */
    public ProductBacklogView(Long id, List<ItemBacklogView> itensBacklog) {
        this.id = id;
        this.itensBacklog = itensBacklog;
    }

    /**
     * Gets the unique identifier of the product backlog.
     *
     * @return The unique identifier of the product backlog.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of the product backlog.
     *
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the list of item backlogs associated with the product backlog.
     *
     * @return The list of item backlogs associated with the product backlog.
     */
    public List<ItemBacklogView> getItensBacklog() {
        return this.itensBacklog;
    }

    /**
     * Sets the list of item backlogs associated with the product backlog.
     *
     * @param itensBacklog The list of item backlogs to set.
     */
    public void setItensBacklog(List<ItemBacklogView> itensBacklog) {
        this.itensBacklog = itensBacklog;
    }

    /**
     * Fluent method to set the identifier of the product backlog.
     *
     * @param id The unique identifier to set.
     * @return The current ProductBacklogView instance for method chaining.
     */
    public ProductBacklogView id(Long id) {
        setId(id);
        return this;
    }

    /**
     * Fluent method to set the list of item backlogs associated with the product backlog.
     *
     * @param itensBacklog The list of item backlogs to set.
     * @return The current ProductBacklogView instance for method chaining.
     */
    public ProductBacklogView itensBacklog(List<ItemBacklogView> itensBacklog) {
        setItensBacklog(itensBacklog);
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
        if (!(o instanceof ProductBacklogView)) {
            return false;
        }
        ProductBacklogView productBacklogView = (ProductBacklogView) o;
        return Objects.equals(id, productBacklogView.id) && Objects.equals(itensBacklog, productBacklogView.itensBacklog);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, itensBacklog);
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
            ", itensBacklog='" + getItensBacklog() + "'" +
            "}";
    }

}
