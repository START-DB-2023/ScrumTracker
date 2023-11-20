package com.db.scrumtrackerapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.repositories.SprintRepository;
import com.db.scrumtrackerapi.services.impl.SprintService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SprintServiceTest {
    
    @Autowired
    @InjectMocks
    private SprintService sprintService;

    @Mock
    private SprintRepository sprintRepository;

    @Test
    @DisplayName("Assert update Sprint return the expected Sprint")
    public void testUpdateItemBacklog(){
        Sprint savedSprint = new Sprint("ExampleGoal", new ArrayList<>(), new ArrayList<>());
        
        when(sprintRepository.findById(eq(1L))).thenReturn(Optional.of(savedSprint));
        
        Sprint expectedSprint = new Sprint("ModifiedExampleGoal", new ArrayList<>(), new ArrayList<>());

        when(sprintRepository.save(eq(expectedSprint))).thenReturn(expectedSprint);

        Sprint actualSpring = sprintService.update(1L, expectedSprint);
        
        assertEquals(expectedSprint, actualSpring);
    }
}
