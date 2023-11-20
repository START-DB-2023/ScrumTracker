package com.db.scrumtrackerapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.ProductBacklog;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductBacklogRepositoryTest {
       
    @Autowired
    private ProductBacklogRepository productBacklogRepository;

    @Autowired
    private ProductRepository productRepository;

    private Product product1 = new Product(
        "FirstExampleName",
        "FirstExampleClient",
        "FirstExampleObjectives",
        "FirstExampleVision",
        "FirstExampleState",
        "FirstExampleReady",
        null
    );

    private Product product2 = new Product(
        "SecondExampleName",
        "SecondExampleClient",
        "SecondExampleObjectives",
        "SecondExampleVision",
        "SecondExampleState",
        "SecondExampleReady",
        null
    );

    private ProductBacklog productBacklog1 = new ProductBacklog(new ArrayList<>(), product1);;
    private ProductBacklog productBacklog2 = new ProductBacklog(new ArrayList<>(), product2);;


    @BeforeAll
    void setup () {
        productRepository.save(product1);
        productRepository.save(product2);
        
        productBacklogRepository.save(productBacklog1);
        productBacklogRepository.save(productBacklog2);
    }

    @Test
    @DisplayName("Assert Getting Product Backlog By Product Id")
    void testGetProductBacklogByProductId(){
        ProductBacklog actualProductBacklog = productBacklogRepository.findByProductId(1L);
        assertEquals(productBacklog1, actualProductBacklog);
        assertNotEquals(productBacklog2, actualProductBacklog);
    }

}
