package com.altioracorp.evaluation.application.usecases.item;

import com.altioracorp.evaluation.domain.ports.in.item.DeleteItemUseCase;
import com.altioracorp.evaluation.domain.ports.out.item.ItemRepositoryPort;

public class DeleteItemUseCaseImpl implements DeleteItemUseCase {
    private final ItemRepositoryPort itemRepositoryPort;

    public DeleteItemUseCaseImpl(ItemRepositoryPort itemRepositoryPort) {
        this.itemRepositoryPort = itemRepositoryPort;
    }

    @Override
    public boolean delete(long id) {
        return itemRepositoryPort.delete(id);
    }
}
