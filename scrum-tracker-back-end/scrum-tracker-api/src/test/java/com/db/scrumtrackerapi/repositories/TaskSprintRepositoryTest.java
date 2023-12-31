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
import com.db.scrumtrackerapi.model.TaskSprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskSprintRepositoryTest {
    
    @Autowired
    ItemBacklogRepository itemBacklogRepository;

    @Autowired
    ProductBacklogRepository productBacklogRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    TaskSprintRepository taskSprintRepository;

    private Product product1 = new Product(
        "FirstExampleName",
        "FirstExampleClient",
        "FirstExampleObjectives",
        "FirstExampleVision",
        "FirstExampleState",
        "FirstExampleReady",
        null, 
        List.of()
    );

    private Product product2 = new Product(
        "SecondExampleName",
        "SecondExampleClient",
        "SecondExampleObjectives",
        "SecondExampleVision",
        "SecondExampleState",
        "SecondExampleReady",
        null,
        List.of()
    );

    private ProductBacklog productBacklog1 = new ProductBacklog(new ArrayList<>(), product1);;
    private ProductBacklog productBacklog2 = new ProductBacklog(new ArrayList<>(), product2);;

    ItemBacklog itemBacklog1 = new ItemBacklog(
        Status.EM_DESENVOLVIMENTO, 
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

    Sprint sprint1 = new Sprint("ExampleGoal", List.of(itemBacklog1), new ArrayList<>(), product1);
    Sprint sprint2 = new Sprint("ExampleGoal", List.of(itemBacklog2), new ArrayList<>(), product2);
    
    TaskSprint taskSprint1 = new TaskSprint("FirstExampleName", itemBacklog1, "FirstExampleDescription", "FirstExampleComments", Status.A_FAZER, Priority.BAIXA, "FirstExampleEffortEstimation", null, sprint1);
    TaskSprint taskSprint2 = new TaskSprint("SecondExampleName", itemBacklog2, "SecondExampleDescription", "SecondExampleComments", Status.A_FAZER, Priority.BAIXA, "SecondExampleEffortEstimation", null, sprint2);

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

        taskSprintRepository.save(taskSprint1);
        taskSprintRepository.save(taskSprint2);
    }

    @Test
    @DisplayName("Assert Getting Item Backlog By Sprint Id")
    void testGetTaskBySprintItem() {
        List<TaskSprint> actualSprintTasks = taskSprintRepository.findBySprintId(1L);
        assertEquals(taskSprint1, actualSprintTasks.get(0));
        assertNotEquals(taskSprint2, actualSprintTasks.get(0));
    }

}
