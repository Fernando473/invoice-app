package com.altioracorp.evaluation.application.usecases.order_detail;

import com.altioracorp.evaluation.domain.models.OrderDetail;
import com.altioracorp.evaluation.domain.ports.in.order_detail.CreateOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.out.order_detail.OrderDetailRepositoryPort;

public class CreateOrderDetailUseCaseImpl implements CreateOrderDetailUseCase {
    private final OrderDetailRepositoryPort orderDetailRepositoryPort;

    public CreateOrderDetailUseCaseImpl(OrderDetailRepositoryPort orderDetailRepositoryPort) {
        this.orderDetailRepositoryPort = orderDetailRepositoryPort;
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) throws Exception {
        return orderDetailRepositoryPort.save(orderDetail);
    }
}
