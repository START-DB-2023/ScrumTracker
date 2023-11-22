package com.db.scrumtrackerapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Product;
import com.db.scrumtrackerapi.model.ProductBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SprintRepositoryTest {
    
    @Autowired
    ItemBacklogRepository itemBacklogRepository;

    @Autowired
    ProductBacklogRepository productBacklogRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SprintRepository sprintRepository;

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

    ItemBacklog itemBacklog1 = new ItemBacklog(
        Status.A_FAZER, 
        Priority.MEDIA, 
        "FirstExampleName", 
"FirstCriteria",
        "FirstExampleEffort", 
        List.of(), 
        "FirstExampleDescription",
        productBacklog1);

    ItemBacklog itemBacklog2 = new ItemBacklog(
        Status.A_FAZER, 
        Priority.MEDIA, 
        "SecondExampleName", 
"FirstCriteria", 
        "SecondExampleEffort", 
        List.of(), 
        "SecondExampleDescription",
        productBacklog2);

    Sprint sprint1 = new Sprint("ExampleGoal", List.of(itemBacklog1), new ArrayList<>());
    Sprint sprint2 = new Sprint("ExampleGoal", List.of(itemBacklog2), new ArrayList<>());

    @BeforeAll
    void setup () {
        productRepository.save(product1);
        productRepository.save(product2);
        
        productBacklogRepository.save(productBacklog1);
        productBacklogRepository.save(productBacklog2);

        itemBacklogRepository.save(itemBacklog1);
        itemBacklogRepository.save(itemBacklog2);

        sprintRepository.save(sprint1);
        sprintRepository.save(sprint2);
    }

    @Test
    @DisplayName("Assert Getting Sprint By Item Backlog Id")
    void testGetSprintByItensBacklog() {
        List<Sprint> actualSprints = sprintRepository.findByItensBacklogId(1L);
        assertEquals(sprint1, actualSprints.get(0));
        assertNotEquals(sprint2, actualSprints.get(0));
    }

}
