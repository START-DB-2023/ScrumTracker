package com.db.scrumtrackerapi.model.dto;
import java.util.List;

import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.model.Sprint;
import com.db.scrumtrackerapi.model.TaskSprint;

public class SprintDTO{

    private String sprintGoals;

    private List<ItemBacklog> itensBacklog;

    private List<TaskSprint> tasksSprints;

    public Sprint toSprint(){
        return new Sprint(sprintGoals, itensBacklog, tasksSprints);
    }
}