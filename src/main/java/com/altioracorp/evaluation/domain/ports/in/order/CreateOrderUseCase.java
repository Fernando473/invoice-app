package com.altioracorp.evaluation.domain.ports.in.order;

import com.altioracorp.evaluation.domain.models.Order;

public interface CreateOrderUseCase {
    Order save(Order order);
}
