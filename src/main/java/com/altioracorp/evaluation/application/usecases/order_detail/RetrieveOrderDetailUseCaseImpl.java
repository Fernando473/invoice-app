package com.altioracorp.evaluation.application.usecases.order_detail;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.models.OrderDetail;
import com.altioracorp.evaluation.domain.ports.in.order_detail.RetrieveOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.out.order_detail.OrderDetailRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveOrderDetailUseCaseImpl implements RetrieveOrderDetailUseCase {
    private final OrderDetailRepositoryPort orderDetailRepositoryPort;

    public RetrieveOrderDetailUseCaseImpl(OrderDetailRepositoryPort orderDetailRepositoryPort) {
        this.orderDetailRepositoryPort = orderDetailRepositoryPort;
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepositoryPort.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(long id) {
        return orderDetailRepositoryPort.findById(id);
    }
}
