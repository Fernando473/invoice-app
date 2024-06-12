package com.altioracorp.evaluation.domain.ports.in.item;

import com.altioracorp.evaluation.domain.models.Item;

public interface CreateItemUseCase {
    Item createTask(Item item);
}
