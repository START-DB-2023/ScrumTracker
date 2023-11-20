package com.db.scrumtrackerapi.services;

import java.util.List;

import com.db.scrumtrackerapi.model.TaskSprint;

public interface ITaskSprintService {

    TaskSprint save(TaskSprint taskSprint);

    TaskSprint updateTaskSprint(Long id, TaskSprint taskSprint);

    List<TaskSprint> findBySprintId(Long SprintId);

    TaskSprint findById(Long id);

    TaskSprint deactivateById(Long id);
}