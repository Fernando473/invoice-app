package com.altioracorp.evaluation.domain.ports.in.order;

import com.altioracorp.evaluation.domain.models.Order;

import java.util.Optional;

public interface UpdateOrderUseCase {
    Optional<Order> update(long id, Order order);
}
