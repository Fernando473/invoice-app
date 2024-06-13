package com.altioracorp.evaluation.application.usecases.order;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.ports.in.order.UpdateOrderUseCase;
import com.altioracorp.evaluation.domain.ports.out.order.OrderRepositoryPort;

import java.util.Optional;

public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {

    private final OrderRepositoryPort orderRepositoryPort;

    public UpdateOrderUseCaseImpl(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Optional<Order> update(long id, Order order) {
        return orderRepositoryPort.update(id, order);
    }
}
