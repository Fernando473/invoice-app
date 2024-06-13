package com.altioracorp.evaluation.application.services;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.ports.in.item.CreateItemUseCase;
import com.altioracorp.evaluation.domain.ports.in.item.DeleteItemUseCase;
import com.altioracorp.evaluation.domain.ports.in.item.RetrieveItemUseCase;
import com.altioracorp.evaluation.domain.ports.in.item.UpdateItemUseCase;

import java.util.List;
import java.util.Optional;

public class ItemService implements CreateItemUseCase, UpdateItemUseCase, RetrieveItemUseCase, DeleteItemUseCase {
    private final CreateItemUseCase createItemUseCase;
    private final UpdateItemUseCase updateItemUseCase;
    private final RetrieveItemUseCase retrieveItemUseCase;
    private final DeleteItemUseCase deleteItemUseCase;

    public ItemService(CreateItemUseCase createItemUseCase, UpdateItemUseCase updateItemUseCase, RetrieveItemUseCase retrieveItemUseCase, DeleteItemUseCase deleteItemUseCase) {
        this.createItemUseCase = createItemUseCase;
        this.updateItemUseCase = updateItemUseCase;
        this.retrieveItemUseCase = retrieveItemUseCase;
        this.deleteItemUseCase = deleteItemUseCase;
    }


    @Override
    public boolean delete(long id) {
        return deleteItemUseCase.delete(id);
    }

    @Override
    public Optional<Item> getItem(long id) {
        return retrieveItemUseCase.getItem(id);
    }

    @Override
    public List<Item> allItems() {
        return retrieveItemUseCase.allItems();
    }

    @Override
    public Optional<Item> update(long id, Item item) {
        return updateItemUseCase.update(id,item);
    }

    @Override
    public Item createItem(Item item) {
        return createItemUseCase.createItem(item);
    }
}
