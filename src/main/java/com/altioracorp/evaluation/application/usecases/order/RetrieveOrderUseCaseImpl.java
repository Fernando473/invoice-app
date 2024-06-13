package com.altioracorp.evaluation.application.usecases.order;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.ports.in.order.DeleteOrderUseCase;
import com.altioracorp.evaluation.domain.ports.in.order.RetrieveOrderUseCase;
import com.altioracorp.evaluation.domain.ports.out.order.OrderRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveOrderUseCaseImpl implements RetrieveOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;

    public RetrieveOrderUseCaseImpl(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Optional<Order> getOrder(long orderId) {
        return orderRepositoryPort.findById(orderId);
    }

    @Override
    public List<Order> allOrders() {
        return orderRepositoryPort.findAll();
    }
}
