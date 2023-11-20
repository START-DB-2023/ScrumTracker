package com.db.scrumtrackerapi.model.dto;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.TaskSprint;
import com.db.scrumtrackerapi.model.enums.Priority;
import com.db.scrumtrackerapi.model.enums.Status;

public class TaskSprintDTO{

    private String name;

    private ItemBacklog itemBacklog;

    private String description;

    private String comments;

    private Status status;

    private Priority priority;

    private String effortEstimation;

    private Customer responsible;

    private Sprint sprint;

    public TaskSprint toTaskSprint(){
        return new TaskSprint(name,itemBacklog,description,comments,status,priority,effortEstimation,responsible,sprint);
    }
}