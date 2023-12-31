package com.db.scrumtrackerapi.model;


import java.util.Objects;

import java.util.List;

import com.db.scrumtrackerapi.model.view.ProductBacklogView;
import com.db.scrumtrackerapi.model.view.ProductView;
import com.db.scrumtrackerapi.model.view.SprintView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents a product entity.
 */
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    /**
     * The name of the product.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The client associated with the product.
     */
    @Column(name = "client", nullable = false)
    private String client;

    /**
     * The objectives of the product.
     */
    @Column(name = "objectives", nullable = true)
    private String objectives;

    /**
     * The vision of the product.
     */
    @Column(name = "vision", nullable = true)
    private String vision;

    /**
     * Definition of ready of the product
     */
    @Column(name = "definitionOfReady", nullable = true)
    private String definitionOfReady;

    /**
     * Definition of done of the product 
     */
    @Column(name = "definitionOfDone", nullable = true)
    private String definitionOfDone;

    /**
     * The product backlog associated with the product.
     */
    @OneToOne(mappedBy = "product")
    private ProductBacklog productBacklog;

    @OneToMany(mappedBy = "product")
    private List<Sprint> sprints;

    
    /**
     * Updates the attributes of the current item backlog with the attributes of the provided item backlog.
     *
     * @param product The item backlog with updated values.
     * @return The updated item backlog.
     */
    public Product update(Product product){
        this.name = product.getName();
        this.client = product.getClient();
        this.objectives = product.getObjectives();
        this.vision = product.getVision();
        this.definitionOfReady = product.getDefinitionOfReady();
        this.definitionOfDone = product.getDefinitionOfDone();
        this.sprints = product.sprints;
        return this;
    }

    /**
     * Protected empty constructor for use by persistence frameworks.
     */
    protected Product() {
    }

    /**
     * Converts the current product object into a product view object. This method creates a new product view object
     * with the same ID, name, client, objectives, vision, definition of done, definition of ready, and product backlog
     * as the current product object.
     *
     * @return A product view object representing the current product.
     */
    public ProductView toView() {
        ProductBacklogView productBacklogView;
        if (productBacklog != null && isActive()) {
            productBacklogView = productBacklog.toView();
        } else {
            productBacklogView = null;
        }
        List<SprintView> sprintViews;
        if (sprints != null) {
            sprintViews = sprints.stream().filter(i -> i.isActive()).map(i -> i.toView()).toList();
        } else {
            sprintViews = null;
        }
        return new ProductView(getId(), name, client, objectives, vision, definitionOfDone, definitionOfReady, productBacklogView, sprintViews);
    }

    /**
     * Creates a new product with specified attributes.
     *
     * @param name          The name of the product.
     * @param client        The client associated with the product.
     * @param objectives    The objectives of the product.
     * @param vision        The vision of the product.
     * @param definitionOfReady         The definitionOfReady of the product.
     * @param definitionOfDone         The readiness status of the product.
     * @param productBacklog The product backlog associated with the product.
     * @param sprints The sprints associated with the product.
     */
    public Product(String name, String client, String objectives, String vision, String definitionOfReady, String definitionOfDone, ProductBacklog productBacklog, List<Sprint> sprints) {
        this.name = name;
        this.client = client;
        this.objectives = objectives;
        this.vision = vision;
        this.definitionOfReady = definitionOfReady;
        this.definitionOfDone = definitionOfDone;
        this.productBacklog = productBacklog;
        this.sprints = sprints;
        super.setActive(true);
        super.setTimestamp();
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
     * Gets the definitionOfReady of the product.
     *
     * @return The definitionOfReady of the product.
     */
    public String getDefinitionOfReady() {
        return this.definitionOfReady
;
    }

    /**
     * Sets the definitionOfReady of the product.
     *
     * @param definitionOfReady The definitionOfReady to set.
     */
    public void setDefinitionOfReady(String definitionOfReady) {
        this.definitionOfReady
 = definitionOfReady;
    }

    /**
     * Gets the readiness status of the product.
     *
     * @return The readiness status of the product.
     */
    public String getDefinitionOfDone() {
        return this.definitionOfDone;
    }

    /**
     * Sets the readiness status of the product.
     *
     * @param definitionOfDone The readiness status to set.
     */
    public void setDefinitionOfDone(String definitionOfDone) {
        this.definitionOfDone = definitionOfDone;
    }

    /**
     * Gets the product backlog associated with the product.
     *
     * @return The product backlog associated with the product.
     */
    public ProductBacklog getProductBacklog() {
        return this.productBacklog;
    }

    /**
     * Sets the product backlog associated with the product.
     *
     * @param productBacklog The product backlog to set.
     */
    public void setProductBacklog(ProductBacklog productBacklog) {
        this.productBacklog = productBacklog;
    }

    /**
     * Gets the sprints associated with the product.
     *
     * @return The sprints associated with the product.
     */
    public List<Sprint> getSprints() {
        return this.sprints;
    }

    /**
     * Sets the sprint associated with the product.
     *
     * @param sprints The sprints to set.
     */
    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
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
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.getName()) &&
                Objects.equals(client, product.getClient()) &&
                Objects.equals(objectives, product.getObjectives()) &&
                Objects.equals(vision, product.getVision()) &&
                Objects.equals(definitionOfReady, product.getDefinitionOfReady()) &&
                Objects.equals(definitionOfDone, product.getDefinitionOfDone());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, client, objectives, vision, definitionOfReady
, definitionOfDone);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", client='" + getClient() + "'" +
                ", objectives='" + getObjectives() + "'" +
                ", vision='" + getVision() + "'" +
                ", definitionOfReady='" + getDefinitionOfReady
        () + "'" +
                ", definitionOfDone='" + getDefinitionOfDone() + "'" +
                "}";
    }
}

