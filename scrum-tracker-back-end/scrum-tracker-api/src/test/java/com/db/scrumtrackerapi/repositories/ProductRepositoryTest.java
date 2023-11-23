package com.db.scrumtrackerapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.db.scrumtrackerapi.model.Product;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductRepositoryTest {
    
    @Autowired
    private ProductRepository productRepository;

    private Product firstProduct = new Product(
        "FirstExampleName",
        "FirstExampleClient",
        "FirstExampleObjectives",
        "FirstExampleVision",
        "FirstExampleState",
        "FirstExampleReady",
        null,
        List.of()
    );

    private Product expectedProduct = new Product(
        "ExampleName",
        "ExampleClient",
        "ExampleObjectives",
        "ExampleVision",
        "ExampleState",
        "ExampleReady",
        null,
        List.of()
    );

    @BeforeAll
    void setup () {
        productRepository.save(firstProduct);
        productRepository.save(expectedProduct);
    }

    @Test
    @DisplayName("Assert Getting The Last Product")
    void testGetLast(){
        Product actualProduct = productRepository.getLast();
        assertEquals(expectedProduct, actualProduct);
        assertNotEquals(firstProduct, actualProduct);
    }

}
