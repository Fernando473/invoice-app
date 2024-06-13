package com.altioracorp.evaluation.application.usecases.item;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.ports.in.item.RetrieveItemUseCase;
import com.altioracorp.evaluation.domain.ports.out.item.ItemRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveItemUseCaseImpl implements RetrieveItemUseCase {
    private final ItemRepositoryPort itemRepositoryPort;

    public RetrieveItemUseCaseImpl(ItemRepositoryPort itemRepositoryPort) {
        this.itemRepositoryPort = itemRepositoryPort;
    }


    @Override
    public Optional<Item> getItem(long id) {
        return itemRepositoryPort.findById(id);
    }

    @Override
    public List<Item> allItems() {
        return itemRepositoryPort.findAll();
    }
}
