package com.altioracorp.evaluation.application.usecases.order_detail;

import com.altioracorp.evaluation.domain.models.OrderDetail;
import com.altioracorp.evaluation.domain.ports.in.order_detail.UpdateOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.out.order_detail.OrderDetailRepositoryPort;

import java.util.Optional;

public class UpdateOrderDetailUseCaseImpl implements UpdateOrderDetailUseCase {
    private final OrderDetailRepositoryPort orderDetailRepositoryPort;

    public UpdateOrderDetailUseCaseImpl(OrderDetailRepositoryPort orderDetailRepositoryPort) {
        this.orderDetailRepositoryPort = orderDetailRepositoryPort;
    }

    @Override
    public Optional<OrderDetail> update(long id, OrderDetail orderDetail) {
        return orderDetailRepositoryPort.update(id, orderDetail);
    }

}
