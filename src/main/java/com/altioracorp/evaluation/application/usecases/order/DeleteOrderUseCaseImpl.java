package com.altioracorp.evaluation.application.usecases.order;

import com.altioracorp.evaluation.domain.ports.in.order.DeleteOrderUseCase;
import com.altioracorp.evaluation.domain.ports.out.order.OrderRepositoryPort;

public class DeleteOrderUseCaseImpl implements DeleteOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;

    public DeleteOrderUseCaseImpl(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public boolean delete(long id) {
        return orderRepositoryPort.delete(id);
    }
}
