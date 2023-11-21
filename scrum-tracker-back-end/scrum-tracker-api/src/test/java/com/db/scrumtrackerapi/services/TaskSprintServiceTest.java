package com.db.scrumtrackerapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
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
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.TaskSprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;
import com.db.scrumtrackerapi.repositories.TaskSprintRepository;
import com.db.scrumtrackerapi.services.impl.TaskSprintService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskSprintServiceTest {
    
    @Autowired
    @InjectMocks
    TaskSprintService taskSprintService;

    @Mock
    TaskSprintRepository taskSprintRepository;


    @Test
    @DisplayName("Assert updateItemBacklog return the expected ItemBacklog")
    public void testUpdateItemBacklog(){      
        ItemBacklog itemBacklog = new ItemBacklog(
            Status.IN_PROGRESS, 
            Priority.MEDIUM, 
            "FirstExampleName", 
        "FirstCriteria",
            "FirstExampleEffort", 
            List.of(), 
            "FirstExampleDescription",
            null);

        Sprint sprint = new Sprint("ExampleGoal", List.of(itemBacklog), new ArrayList<>());

        TaskSprint savedTaskSprint = new TaskSprint("FirstExampleName", itemBacklog, "FirstExampleDescription", "FirstExampleComments", Status.IN_PROGRESS, Priority.LOW, "FirstExampleEffortEstimation", null, sprint);

        when(taskSprintRepository.findById(eq(1L))).thenReturn(Optional.of(savedTaskSprint));
        
        TaskSprint expectedTaskSprint = new TaskSprint("ModifiedExampleName", itemBacklog, "ModifiedExampleDescription", "ModifiedExampleComments", Status.IN_PROGRESS, Priority.LOW, "ModifiedExampleEffortEstimation", null, sprint);

        when(taskSprintRepository.save(eq(expectedTaskSprint))).thenReturn(expectedTaskSprint);

        TaskSprint actualTaskSprint = taskSprintService.update(1L, expectedTaskSprint);
        
        assertEquals(expectedTaskSprint, actualTaskSprint);
    }

}
