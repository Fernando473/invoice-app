package com.altioracorp.evaluation.domain.ports.in.item;

import com.altioracorp.evaluation.domain.models.Item;

import java.util.Optional;

public interface UpdateItemUseCase {
    Optional<Item> update(long id, Item item);
}
