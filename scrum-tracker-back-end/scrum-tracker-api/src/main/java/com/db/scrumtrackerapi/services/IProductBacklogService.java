package com.db.scrumtrackerapi.services;

import com.db.scrumtrackerapi.model.ProductBacklog;

public interface IProductBacklogService {

    ProductBacklog save(ProductBacklog productBacklog);

    ProductBacklog findByProductId(Long productId);

    ProductBacklog findById(Long id);

    ProductBacklog desactivateById(Long id);

    ProductBacklog update(Long id, ProductBacklog productBacklog);
}
