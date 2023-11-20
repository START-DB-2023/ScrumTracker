package com.db.scrumtrackerapi.model.dto;
import java.util.List;

import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.ProductBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;

public class ItemBacklogDTO{

    private Status status;

    private Priority priority;

    private String name;

    private List<String> criteriaAcceptance;

    private String effortEstimation;

    private List<Sprint> sprints;

    private String description;

    private ProductBacklog productBacklog;

	public ItemBacklog toItemBacklog() {
		return new ItemBacklog(status,priority,name,criteriaAcceptance,effortEstimation,sprints,description,productBacklog);
	}
    
}