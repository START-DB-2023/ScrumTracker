package com.db.scrumtrackerapi.model.dto;
import jakarta.validation.constraints.NotBlank;

public class ItemBacklogDTO{

    @NotBlank(message = "Blank Field.")
    private String name;
    
}