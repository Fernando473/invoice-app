package com.altioracorp.evaluation.application.usecases.item;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.ports.in.item.UpdateItemUseCase;
import com.altioracorp.evaluation.domain.ports.out.item.ItemRepositoryPort;

import java.util.Optional;

public class UpdateItemUseCaseImpl implements UpdateItemUseCase {
    private final ItemRepositoryPort itemRepositoryPort;

    public UpdateItemUseCaseImpl(ItemRepositoryPort itemRepositoryPort) {
        this.itemRepositoryPort = itemRepositoryPort;
    }

    @Override
    public Optional<Item> update(long id, Item item) {
        return itemRepositoryPort.update(id,item);
    }
}
