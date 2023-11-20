package com.db.scrumtrackerapi.services;

import java.util.List;

import com.db.scrumtrackerapi.model.ItemBacklog;

public interface IItemBacklogService {
    
    List<ItemBacklog> findByProductBacklogId(Long id);

    List<ItemBacklog> findBySprintId(Long id);

    ItemBacklog save(ItemBacklog itemBacklog);

    ItemBacklog update(Long id, ItemBacklog itemBacklog);

    ItemBacklog findById(Long id);

    ItemBacklog deactivateById(Long id);
}
