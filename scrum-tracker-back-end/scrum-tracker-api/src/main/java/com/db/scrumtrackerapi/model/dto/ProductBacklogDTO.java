package com.db.scrumtrackerapi.model.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.ProductBacklog;

/**
 * Data Transfer Object (DTO) representing product backlog information.
 */
public class ProductBacklogDTO{


    /**
     * The product associated with this product backlog.
     */
    private Product product;

    /**
     * The list of backlog items associated with this product.
     */
    private List<ItemBacklog> itensBacklog;

    
    public ProductBacklog toProductBacklog() {
        return new ProductBacklog(itensBacklog, product);
    }

    /**
     * Protected empty constructor for use by persistence frameworks.
     */
    protected ProductBacklogDTO() {
    }

    /**
     * Constructor to create a new product backlog dto with a product and a list of items.
     * 
     * @param product The product associated with this backlog.
     * @param itensBacklog The list of items associated with this backlog.
     */
    public ProductBacklogDTO(List<ItemBacklog> itensBacklog, Product product) {
        this.itensBacklog = itensBacklog;
        this.product = product;
    }


    /**
     * Gets the product associated with this backlog.
     * 
     * @return The associated product.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Sets the product associated with this backlog.
     * 
     * @param product The product to be associated.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the list of items associated with this backlog.
     * 
     * @return The list of associated items.
     */
    public List<ItemBacklog> getItensBacklog() {
        return this.itensBacklog;
    }

    /**
     * Sets the list of items associated with this backlog.
     * 
     * @param items The list of items to be associated.
     */
    public void setItensBacklog(List<ItemBacklog> items) {
        this.itensBacklog = items;
    }


    /**
     * Overridden to compare equality based on the product and the list of items.
     * 
     * @param o The object to be compared.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductBacklog)) {
            return false;
        }
        ProductBacklog productBacklog = (ProductBacklog) o;
        return Objects.equals(product, productBacklog.getProduct()) 
        && Objects.equals(Arrays.hashCode(itensBacklog.stream().map(ItemBacklog::getId).toArray()), Arrays.hashCode(productBacklog.getItensBacklog().stream().map(ItemBacklog::getId).toArray()));
    }

    /**
     * Overridden to generate a hash code based on the product and the list of items.
     * 
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(product, Arrays.hashCode(itensBacklog.stream().map(ItemBacklog::getId).toArray()));
    }

    /**
     * Overridden to generate a string representation of the object.
     * 
     * @return The string representation.
     */
    @Override
    public String toString() {
        return "{" +
            " productId='" + getProduct().getId() + "'" +
            ", itemBacklogIds='" + getItensBacklog().stream().map(i -> i.getId()) + "'" +
            "}";
    }
}