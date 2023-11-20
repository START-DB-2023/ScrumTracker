package com.db.scrumtrackerapi.model.dto;

import java.util.List;

import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.ProductBacklog;

public class ProductBacklogDTO{

    private Product product;

    private List<ItemBacklog> itensBacklog;

    public ProductBacklog toProductBacklog() {
        return new ProductBacklog(itensBacklog, product);
    }
}