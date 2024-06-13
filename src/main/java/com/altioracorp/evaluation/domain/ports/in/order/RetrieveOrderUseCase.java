package com.altioracorp.evaluation.domain.ports.in.order;

import com.altioracorp.evaluation.domain.models.Order;

import java.util.List;
import java.util.Optional;

public interface RetrieveOrderUseCase {
    Optional<Order> getOrder(long orderId);

    List<Order> allOrders();
}
