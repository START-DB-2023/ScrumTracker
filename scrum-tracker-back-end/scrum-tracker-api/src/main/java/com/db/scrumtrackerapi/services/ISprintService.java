package com.db.scrumtrackerapi.services;

import java.util.List;

import com.db.scrumtrackerapi.model.Sprint;

public interface ISprintService {
    
    List<Sprint> findByItemBacklogId(Long id);

    Sprint save(Sprint sprint);

    Sprint updateSprint(Long id, Sprint sprint);

    Sprint findById(Long id);

    Sprint deactivateById(Long id);
}
