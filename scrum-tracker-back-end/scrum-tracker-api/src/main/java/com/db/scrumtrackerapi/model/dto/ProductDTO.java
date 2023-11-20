package com.db.scrumtrackerapi.model.dto;

import java.util.Objects;

import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.ProductBacklog;

import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

    @NotBlank(message = "Blank Field.")
    private String name;

    @NotBlank(message = "Blank Field.")
    private String client;

    private String objectives;

    private String vision;

    private String definitionOfDone;

    private String definitionOfReady;

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


    public ProductDTO(String name, String client, String objectives, String vision, String definitionOfDone, String definitionOfReady, ProductBacklog productBacklog) {
        this.name = name;
        this.client = client;
        this.objectives = objectives;
        this.vision = vision;
        this.definitionOfDone = definitionOfDone;
        this.definitionOfReady = definitionOfReady;
        this.productBacklog = productBacklog;
    }
    

    protected ProductDTO() {
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getObjectives() {
        return this.objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getVision() {
        return this.vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getdefinitionOfDone() {
        return this.definitionOfDone;
    }

    public void setdefinitionOfDone(String definitionOfDone) {
        this.definitionOfDone = definitionOfDone;
    }

    public String getdefinitionOfReady() {
        return this.definitionOfReady;
    }

    public void setdefinitionOfReady(String definitionOfReady) {
        this.definitionOfReady = definitionOfReady;
    }

    public ProductBacklog getProductBacklog() {
        return this.productBacklog;
    }

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
                ", definitionOfDone='" + getdefinitionOfDone() + "'" +
                ", definitionOfReady='" + getdefinitionOfReady() + "'" +
                "}";
    }

}