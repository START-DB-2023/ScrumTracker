package com.db.scrumtrackerapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.repositories.ProductRepository;
import com.db.scrumtrackerapi.services.impl.ProductService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    
    @Autowired
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Assert Get Last Return The Expected Product")
    public void testGetLast() {
        Product expectedProduct = new Product(
            "ExampleName",
            "ExampleClient",
            "ExampleObjectives",
            "ExampleVision",
            "ExampleState",
            "ExampleReady",
            null,
            List.of()
        );

        when(productRepository.getLast()).thenReturn(expectedProduct);
        Product actualProduct = productService.getLast();
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testUpdateProduct() {

        Product savedProduct = new Product(
            "ExampleName",
            "ExampleClient",
            "ExampleObjectives",
            "ExampleVision",
            "ExampleState",
            "ExampleReady",
            null,
            List.of()
        );

        when(productRepository.findById(eq(1L))).thenReturn(Optional.of(savedProduct));
        
        Product expectedProduct = new Product(
            "ModifiedExampleName",
            "ModifiedExampleClient",
            "ModifiedExampleObjectives",
            "ModifiedExampleVision",
            "ModifiedExampleState",
            "ModifiedReady",
            null,
            List.of()
        );

        when(productRepository.save(eq(expectedProduct))).thenReturn(expectedProduct);
        Product actualProduct = productService.update(1L, expectedProduct);
        assertEquals(expectedProduct, actualProduct);
    }
}
