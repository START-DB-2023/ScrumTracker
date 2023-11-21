package com.db.scrumtrackerapi.model.dto;

import java.util.Objects;

import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.ProductBacklog;

import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

    /**
     * The name of the product.
     */
    @NotBlank(message = "Blank Field.")
    private String name;
    
    /**
     * The client associated with the product.
     */
    @NotBlank(message = "Blank Field.")
    private String client;

    /**
     * The objectives of the product.
     */
    @NotBlank(message = "Blank Field.")
    private String objectives;

    /**
     * The vision of the product.
     */
    @NotBlank(message = "Blank Field.")
    private String vision;

    /**
     * Definition of ready of the product
     */    
    @NotBlank(message = "Blank Field.")
    private String definitionOfDone;

    /**
     * Definition of done of the product 
     */
    @NotBlank(message = "Blank Field.")
    private String definitionOfReady;

    /**
     * The product backlog associated with the product.
     */
    private ProductBacklog productBacklog;

    /**
     * Converts the DTO object to a Product entity.
     *
     * @return A Product entity created from the DTO.
     */
    public Product toProduct(){
        Product product = new Product(
            this.name,
            this.client,
            this.objectives,
            this.vision,
            this.definitionOfDone,
            this.definitionOfReady,
            this.productBacklog
        );

        return product;
    }

    /**
     * Creates a new product dto with specified attributes.
     *
     * @param name          The name of the product.
     * @param client        The client associated with the product.
     * @param objectives    The objectives of the product.
     * @param vision        The vision of the product.
     * @param definitionOfReady         The definitionOfReady of the product.
     * @param definitionOfDone         The readiness status of the product.
     * @param productBacklog The product backlog associated with the product.
     */
    public ProductDTO(String name, String client, String objectives, String vision, String definitionOfDone, String definitionOfReady, ProductBacklog productBacklog) {
        this.name = name;
        this.client = client;
        this.objectives = objectives;
        this.vision = vision;
        this.definitionOfDone = definitionOfDone;
        this.definitionOfReady = definitionOfReady;
        this.productBacklog = productBacklog;
    }
    
    /**
     * Protected empty constructor for use by persistence frameworks.
     */
    protected ProductDTO() {
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
                Objects.equals(definitionOfDone, product.getDefinitionOfDone()) &&
                Objects.equals(definitionOfReady, product.getDefinitionOfReady());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, client, objectives, vision, definitionOfDone, definitionOfReady);
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
                ", definitionOfDone='" + getDefinitionOfDone() + "'" +
                ", definitionOfReady='" + getDefinitionOfReady() + "'" +
                "}";
    }

}