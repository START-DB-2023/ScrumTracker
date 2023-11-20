package com.db.scrumtrackerapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.db.scrumtrackerapi.model.ProductBacklog;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;
import com.db.scrumtrackerapi.repositories.ItemBacklogRepository;
import com.db.scrumtrackerapi.services.impl.ItemBacklogService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ItemBacklogServiceTest {
    
    @Autowired
    @InjectMocks
    private ItemBacklogService itemBacklogService;

    @Mock
    private ItemBacklogRepository itemBacklogRepository;

    @Test
    @DisplayName("Assert updateItemBacklog return the expected ItemBacklog")
    public void testUpdateItemBacklog(){
        
        ProductBacklog productBacklog = new ProductBacklog(new ArrayList<>(), null);

        ItemBacklog savedItemBacklog = new ItemBacklog(
            Status.TODO, 
            Priority.MEDIUM, 
            "FirstExampleName", 
            Arrays.asList("FirstCriteria", "SecondCriteria"),
            "FirstExampleEffort", 
            List.of(), 
            "FirstExampleDescription",
            productBacklog);
        
        when(itemBacklogRepository.findById(eq(1L))).thenReturn(Optional.of(savedItemBacklog));
             
        ItemBacklog itemBacklog = new ItemBacklog(
            Status.TODO, 
            Priority.MEDIUM, 
            "FirstExampleName", 
            Arrays.asList("FirstCriteria", "SecondCriteria"),
            "FirstExampleEffort", 
            List.of(), 
            "FirstExampleDescription",
            productBacklog);

        when(itemBacklogRepository.save(eq(itemBacklog))).thenReturn(itemBacklog);

        ItemBacklog actualItemBacklog = itemBacklogService.update(1L, itemBacklog);
        assertEquals(itemBacklog, actualItemBacklog);
    }

    @Test
    @DisplayName("Assert deactivate ItemBacklog return the expected ItemBacklog")
    public void testDeactivateItemBacklog(){
        
        ProductBacklog productBacklog = new ProductBacklog(new ArrayList<>(), null);

        ItemBacklog savedItemBacklog = new ItemBacklog(
            Status.TODO, 
            Priority.MEDIUM, 
            "FirstExampleName", 
            Arrays.asList("FirstCriteria", "SecondCriteria"),
            "FirstExampleEffort", 
            List.of(), 
            "FirstExampleDescription",
            productBacklog);
        
        when(itemBacklogRepository.findById(eq(1L))).thenReturn(Optional.of(savedItemBacklog));
             
        ItemBacklog expectedItemBacklog = new ItemBacklog(
            Status.TODO, 
            Priority.MEDIUM, 
            "FirstExampleName", 
            Arrays.asList("FirstCriteria", "SecondCriteria"),
            "FirstExampleEffort", 
            List.of(), 
            "FirstExampleDescription",
            productBacklog);

        expectedItemBacklog.setActive(false);

        when(itemBacklogRepository.save(eq(expectedItemBacklog))).thenReturn(expectedItemBacklog);

        ItemBacklog actualItemBacklog = itemBacklogService.deactivateById(1L);
        assertEquals(expectedItemBacklog, actualItemBacklog);
    }
}
