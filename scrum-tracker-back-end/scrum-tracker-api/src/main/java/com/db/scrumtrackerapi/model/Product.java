package com.db.scrumtrackerapi.model;


import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
     * The state of the product.
     */
    @Column(name = "state", nullable = true)
    private String state;

    /**
     * The readiness status of the product.
     */
    @Column(name = "ready", nullable = true)
    private String ready;

    /**
     * The product backlog associated with the product.
     */
    @OneToOne(mappedBy = "product")
    private ProductBacklog productBacklog;

    
    /**
     * Updates the attributes of the current item backlog with the attributes of the provided item backlog.
     *
     * @param product The item backlog with updated values.
     * @return The updated item backlog.
     */
    public Product updateProduct(Product product){
        this.name = product.getName();
        this.client = product.getClient();
        this.objectives = product.getObjectives();
        this.vision = product.getVision();
        this.state = product.getState();
        this.ready = product.getReady();
        return this;
    }

    /**
     * Protected empty constructor for use by persistence frameworks.
     */
    protected Product() {
    }

    /**
     * Creates a new product with specified attributes.
     *
     * @param name          The name of the product.
     * @param client        The client associated with the product.
     * @param objectives    The objectives of the product.
     * @param vision        The vision of the product.
     * @param state         The state of the product.
     * @param ready         The readiness status of the product.
     * @param productBacklog The product backlog associated with the product.
     */
    public Product(String name, String client, String objectives, String vision, String state, String ready, ProductBacklog productBacklog) {
        this.name = name;
        this.client = client;
        this.objectives = objectives;
        this.vision = vision;
        this.state = state;
        this.ready = ready;
        this.productBacklog = productBacklog;
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
     * Gets the state of the product.
     *
     * @return The state of the product.
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of the product.
     *
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the readiness status of the product.
     *
     * @return The readiness status of the product.
     */
    public String getReady() {
        return this.ready;
    }

    /**
     * Sets the readiness status of the product.
     *
     * @param ready The readiness status to set.
     */
    public void setReady(String ready) {
        this.ready = ready;
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
                Objects.equals(state, product.getState()) &&
                Objects.equals(ready, product.getReady());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, client, objectives, vision, state, ready);
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
                ", state='" + getState() + "'" +
                ", ready='" + getReady() + "'" +
                "}";
    }
}

