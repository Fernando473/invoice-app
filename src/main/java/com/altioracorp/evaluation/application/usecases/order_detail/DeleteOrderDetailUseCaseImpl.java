package com.altioracorp.evaluation.application.usecases.order_detail;

import com.altioracorp.evaluation.domain.ports.in.order_detail.DeleteOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.out.order_detail.OrderDetailRepositoryPort;

public class DeleteOrderDetailUseCaseImpl implements DeleteOrderDetailUseCase {
    private final OrderDetailRepositoryPort orderDetailRepositoryPort;

    public DeleteOrderDetailUseCaseImpl(OrderDetailRepositoryPort orderDetailRepositoryPort) {
        this.orderDetailRepositoryPort = orderDetailRepositoryPort;
    }

    @Override
    public Boolean delete(long id) {
        return orderDetailRepositoryPort.delete(id);
    }
}
