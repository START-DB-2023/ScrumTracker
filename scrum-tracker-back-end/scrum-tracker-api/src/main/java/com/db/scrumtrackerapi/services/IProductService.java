package com.db.scrumtrackerapi.services;

import com.db.scrumtrackerapi.model.Product;

public interface IProductService {
    
    Product getLast();

    Product save(Product product);

    Product update(Long id, Product product);

    Product findById(Long id);

    Product deactivateById(Long id);
}
