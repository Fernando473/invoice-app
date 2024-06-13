package com.altioracorp.evaluation.infrastructure.repositories.item;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.ports.out.item.ItemRepositoryPort;
import com.altioracorp.evaluation.infrastructure.entities.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JPAItemRepositoryAdapter implements ItemRepositoryPort {
    private final JPAItemRepository jpaItemRepository;

    public JPAItemRepositoryAdapter(JPAItemRepository jpaItemRepository) {
        this.jpaItemRepository = jpaItemRepository;
    }


    @Override
    public Optional<Item> findById(long id) {
        return jpaItemRepository.findById(id).map(ItemEntity::toDomainModel);
    }

    @Override
    public List<Item> findAll() {
        return jpaItemRepository.findAll().stream().map(ItemEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> update(long id, Item item) {
        if (jpaItemRepository.existsById(id)) {
            ItemEntity itemEntity = ItemEntity.fromDomainModel(item);
            ItemEntity itemEntityFound = jpaItemRepository.save(itemEntity);
            return Optional.of(itemEntityFound.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Item save(Item item) {
        ItemEntity itemEntity = ItemEntity.fromDomainModel(item);
        ItemEntity itemEntitySaved = jpaItemRepository.save(itemEntity);
        return itemEntitySaved.toDomainModel();
    }

    @Override
    public Boolean delete(long id) {
        if (jpaItemRepository.existsById(id)) {
            jpaItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
