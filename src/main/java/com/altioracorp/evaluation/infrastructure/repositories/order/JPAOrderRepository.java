package com.altioracorp.evaluation.infrastructure.repositories.order;

import com.altioracorp.evaluation.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAOrderRepository extends JpaRepository<OrderEntity, Long> {
}
