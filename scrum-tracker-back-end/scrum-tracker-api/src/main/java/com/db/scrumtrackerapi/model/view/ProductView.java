package com.db.scrumtrackerapi.model.view;

import java.util.List;
import java.util.Objects;

/**
 * Represents a view of a product, containing information such as its name, client, objectives, vision,
 * definition of done, definition of ready, and a view of the associated product backlog.
 */
public class ProductView {

    /**
     * The unique identifier of the product.
     */
    private Long id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The client associated with the product.
     */
    private String client;

    /**
     * The objectives of the product.
     */
    private String objectives;

    /**
     * The vision of the product.
     */
    private String vision;

    /**
     * The definition of done for the product.
     */
    private String definitionOfDone;

    /**
     * The definition of ready for the product.
     */
    private String definitionOfReady;

    /**
     * The view of the product backlog associated with the product.
     */
    private ProductBacklogView productBacklogView;

    /**
     * The view of the sprint backlog associated with the product.
     */
    private List<SprintView> sprintViews; 

    /**
     * Default constructor for use by persistence frameworks.
     */
    protected ProductView() {
    }

    /**
     * Creates a new ProductView with the specified attributes.
     *
     * @param id The unique identifier of the product.
     * @param name The name of the product.
     * @param client The client associated with the product.
     * @param objectives The objectives of the product.
     * @param vision The vision of the product.
     * @param definitionOfDone The definition of done for the product.
     * @param definitionOfReady The definition of ready for the product.
     * @param productBacklogView The view of the product backlog associated with the product.
     * @param SprintViews The view of the sprints associated with the product
     */
    public ProductView(Long id, String name, String client, String objectives, String vision, String definitionOfDone, String definitionOfReady, ProductBacklogView productBacklogView, List<SprintView> sprintViews) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.objectives = objectives;
        this.vision = vision;
        this.definitionOfDone = definitionOfDone;
        this.definitionOfReady = definitionOfReady;
        this.productBacklogView = productBacklogView;
        this.sprintViews = sprintViews;
    }

    /**
     * Gets the unique identifier of the product.
     *
     * @return The unique identifier of the product.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the client associated with the product.
     *
     * @return The client associated with the product.
     */
    public String getClient() {
        return this.client;
    }

    /**
     * Sets the client associated with the product.
     *
     * @param client The client to set.
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets the objectives of the product.
     *
     * @return The objectives of the product.
     */
    public String getObjectives() {
        return this.objectives;
    }

    /**
     * Sets the objectives of the product.
     *
     * @param objectives The objectives to set.
     */
    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    /**
     * Gets the vision of the product.
     *
     * @return The vision of the product.
     */
    public String getVision() {
        return this.vision;
    }

    /**
     * Sets the vision of the product.
     *
     * @param vision The vision to set.
     */
    public void setVision(String vision) {
        this.vision = vision;
    }

    /**
     * Gets the definition of done for the product.
     *
     * @return The definition of done for the product.
     */
    public String getDefinitionOfDone() {
        return this.definitionOfDone;
    }

    /**
     * Sets the definition of done for the product.
     *
     * @param definitionOfDone The definition of done to set.
     */
    public void setDefinitionOfDone(String definitionOfDone) {
        this.definitionOfDone = definitionOfDone;
    }

    /**
     * Gets the definition of ready for the product.
     *
     * @return The definition of ready for the product.
     */
    public String getDefinitionOfReady() {
        return this.definitionOfReady;
    }

    /**
     * Sets the definition of ready for the product.
     *
     * @param definitionOfReady The definition of ready to set.
     */
    public void setDefinitionOfReady(String definitionOfReady) {
        this.definitionOfReady = definitionOfReady;
    }

    /**
     * Gets the view of the product backlog associated with the product.
     *
     * @return The view of the product backlog associated with the product.
     */
    public ProductBacklogView getProductBacklogView() {
        return this.productBacklogView;
    }

    /**
     * Sets the view of the product backlog associated with the product.
     *
     * @param productBacklogView The view of the product backlog to set.
     */
    public void setProductBacklogView(ProductBacklogView productBacklogView) {
        this.productBacklogView = productBacklogView;
    }

    /**
     * Gets the views of the sprints associated with the product.
     *
     * @return The view of the sprints associated with the product.
     */
    public List<SprintView> getSprintViews() {
        return this.sprintViews;
    }

    /**
     * Sets the view of the sprints associated with the product.
     *
     * @param sprintViews lis of views of the sprints to set.
     */
    public void setSprintsView(List<SprintView> sprintViews) {
        this.sprintViews = sprintViews;
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
        if (!(o instanceof ProductView)) {
            return false;
        }
        ProductView productView = (ProductView) o;
        return Objects.equals(id, productView.id) && Objects.equals(name, productView.name) && Objects.equals(client, productView.client) && Objects.equals(objectives, productView.objectives) && Objects.equals(vision, productView.vision) && Objects.equals(definitionOfDone, productView.definitionOfDone) && Objects.equals(definitionOfReady, productView.definitionOfReady) && Objects.equals(productBacklogView, productView.productBacklogView) && Objects.equals(sprintViews, productView.sprintViews);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, client, objectives, vision, definitionOfDone, definitionOfReady, productBacklogView, sprintViews);
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
            ", client='" + getClient() + "'" +
            ", objectives='" + getObjectives() + "'" +
            ", vision='" + getVision() + "'" +
            ", definitionOfDone='" + getDefinitionOfDone() + "'" +
            ", definitionOfReady='" + getDefinitionOfReady() + "'" +
            ", productBacklogView='" + getProductBacklogView() + "'" +
            ", sprintViews='" + getSprintViews() + "'" +
            "}";
    }
}

