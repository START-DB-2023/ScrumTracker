package com.db.scrumtrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.dto.ProductDTO;
import com.db.scrumtrackerapi.services.impl.ProductService;


@RestController
@RequestMapping(value = "/product")
public class ProductController{

    @Autowired
    ProductService productService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    ResponseEntity<Product> deactivateById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @RequestMapping(value = "/", method=RequestMethod.GET)
    ResponseEntity<Product> getLast(){
        return ResponseEntity.ok().body(productService.getLast());
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    ResponseEntity<Product> save(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok().body(productService.save(productDTO.toProduct()));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok().body(productService.update(id, productDTO.toProduct()));
    }
}