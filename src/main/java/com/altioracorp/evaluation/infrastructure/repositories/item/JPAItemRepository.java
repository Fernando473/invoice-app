package com.altioracorp.evaluation.infrastructure.repositories.item;

import com.altioracorp.evaluation.infrastructure.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAItemRepository extends JpaRepository<ItemEntity,Long> {
}
