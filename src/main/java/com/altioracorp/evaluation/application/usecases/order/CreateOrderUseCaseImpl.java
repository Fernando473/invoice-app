package com.altioracorp.evaluation.application.usecases.order;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.ports.in.order.CreateOrderUseCase;
import com.altioracorp.evaluation.domain.ports.out.order.OrderRepositoryPort;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;

    public CreateOrderUseCaseImpl(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order save(Order order) {
        return orderRepositoryPort.save(order);
    }
}
