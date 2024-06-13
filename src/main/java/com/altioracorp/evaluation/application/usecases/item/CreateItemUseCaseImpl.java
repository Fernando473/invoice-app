package com.altioracorp.evaluation.application.usecases.item;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.ports.in.item.CreateItemUseCase;
import com.altioracorp.evaluation.domain.ports.out.item.ItemRepositoryPort;

public class CreateItemUseCaseImpl implements CreateItemUseCase {
    private final ItemRepositoryPort itemRepositoryPort;

    public CreateItemUseCaseImpl(ItemRepositoryPort itemRepositoryPort) {
        this.itemRepositoryPort = itemRepositoryPort;
    }

    @Override
    public Item createItem(Item item) {
        return itemRepositoryPort.save(item);
    }


}
