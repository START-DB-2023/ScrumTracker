package com.db.scrumtrackerapi.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.ItemBacklog;
import com.db.scrumtrackerapi.repositories.ItemBacklogRepository;
import com.db.scrumtrackerapi.services.IItemBacklogService;

/**
 * Service class for managing {@link ItemBacklog} entities.
 * Implements the {@link IItemBacklogService} interface.
 */
@Service
public class ItemBacklogService implements IItemBacklogService {

    @Autowired
    ItemBacklogRepository itemBacklogRepository;

    /**
     * Retrieves a list of {@link ItemBacklog} entities based on the provided product backlog ID.
     *
     * @param id The ID of the product backlog.
     * @return A list of {@link ItemBacklog} entities.
     */
    @Override
    public List<ItemBacklog> findByProductBacklogId(Long id) {
        return itemBacklogRepository.findByProductBacklogId(id).stream().filter(i -> i.isActive()).toList();
    }

    /**
     * Retrieves a list of {@link ItemBacklog} entities based on the provided sprint ID.
     *
     * @param id The ID of the sprint.
     * @return A list of {@link ItemBacklog} entities.
     */
    @Override
    public List<ItemBacklog> findBySprintId(Long id) {
        return itemBacklogRepository.findBySprintId(id).stream().filter(i -> i.isActive()).toList();
    }

    /**
     * Saves a new {@link ItemBacklog} entity.
     *
     * @param itemBacklog The {@link ItemBacklog} entity to be saved.
     * @return The saved {@link ItemBacklog} entity.
     */
    @Override
    public ItemBacklog save(ItemBacklog itemBacklog) {
        return itemBacklogRepository.save(itemBacklog);
    }

    /**
     * Updates an existing {@link ItemBacklog} entity with the provided ID.
     *
     * @param id          The ID of the {@link ItemBacklog} entity to be updated.
     * @param itemBacklog The updated {@link ItemBacklog} entity.
     * @return The updated {@link ItemBacklog} entity.
     * @throws EntityNotFoundException If the {@link ItemBacklog} with the given ID is not found.
     */
    @Override
    public ItemBacklog update(Long id, ItemBacklog itemBacklog) {
        Optional<ItemBacklog> savedItemBacklog = itemBacklogRepository.findById(id);
        if (savedItemBacklog.isPresent() && savedItemBacklog.get().isActive()) {
            ItemBacklog newItemBacklog = savedItemBacklog.get().updateItemBacklog(itemBacklog);
            return itemBacklogRepository.save(newItemBacklog);
        } else {
            throw new EntityNotFoundException("ItemBacklog with id " + itemBacklog.getId() + " was not found.");
        }
    }

    /**
     * Retrieves a {@link ItemBacklog} entity based on the provided ID.
     *
     * @param id The ID of the {@link ItemBacklog} entity to be retrieved.
     * @return The {@link ItemBacklog} entity.
     * @throws EntityNotFoundException If the {@link ItemBacklog} with the given ID is not found.
     */
    @Override
    public ItemBacklog findById(Long id) {
        Optional<ItemBacklog> itemBacklog = itemBacklogRepository.findById(id);
        if (itemBacklog.isPresent() && itemBacklog.get().isActive()) {
            return itemBacklog.get();
        } else {
            throw new EntityNotFoundException("ItemBacklog with id " + id + " was not found.");
        }
    }

    /**
     * Deactivate a {@link ItemBacklog} entity based on the provided ID.
     *
     * @param id The ID of the {@link ItemBacklog} entity to be retrieved.
     * @return The {@link ItemBacklog} entity.
     * @throws EntityNotFoundException If the {@link ItemBacklog} with the given ID is not found.
     */
    @Override
    public ItemBacklog deactivateById(Long id) {
        Optional<ItemBacklog> itemBacklog = itemBacklogRepository.findById(id);
        if (itemBacklog.isPresent() && itemBacklog.get().isActive()) {
            itemBacklog.get().setActive(false);
            return itemBacklogRepository.save(itemBacklog.get());
        } else {
            throw new EntityNotFoundException("ItemBacklog with id " + id + " was not found.");
        }
    }
}
