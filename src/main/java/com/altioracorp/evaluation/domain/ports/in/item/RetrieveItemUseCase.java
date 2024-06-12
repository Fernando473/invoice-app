package com.altioracorp.evaluation.domain.ports.in.item;

import com.altioracorp.evaluation.domain.models.Item;

import java.util.List;
import java.util.Optional;

public interface RetrieveItemUseCase {
    Optional<Item> getItem(long id);

    List<Item> allItems();

}
