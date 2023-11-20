package com.db.scrumtrackerapi.model.dto;

import java.util.List;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.ProductBacklog;

import jakarta.validation.constraints.NotNull;

public class ProductBacklogDTO{

    @NotNull(message = "Product cannot be null")
    private Long productId;

    @NotNull(message = "Items cannot be null")
    private List<ItemBacklog> itensBacklog;

    @NotNull(message = "Active status cannot be null")
    private Boolean active;

    public ProductBacklog toProductBacklog() {
        return new ProductBacklog(itensBacklog, null);
    }
}