package com.altioracorp.evaluation.domain.ports.out.item;

import com.altioracorp.evaluation.domain.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepositoryPort {
    Optional<Item> findById(long id);

    List<Item> findAll();

    Optional<Item> update(long id, Item item);

    Item save(Item item);

    Boolean delete(long id);
}
