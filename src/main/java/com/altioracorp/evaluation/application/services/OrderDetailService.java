package com.altioracorp.evaluation.application.services;

import com.altioracorp.evaluation.domain.models.OrderDetail;
import com.altioracorp.evaluation.domain.ports.in.order_detail.CreateOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.in.order_detail.DeleteOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.in.order_detail.RetrieveOrderDetailUseCase;
import com.altioracorp.evaluation.domain.ports.in.order_detail.UpdateOrderDetailUseCase;

import java.util.List;
import java.util.Optional;

public class OrderDetailService implements CreateOrderDetailUseCase, RetrieveOrderDetailUseCase, DeleteOrderDetailUseCase, UpdateOrderDetailUseCase {
    private final CreateOrderDetailUseCase createOrderDetailUseCase;
    private final RetrieveOrderDetailUseCase retrieveOrderDetailUseCase;
    private final DeleteOrderDetailUseCase deleteOrderDetailUseCase;
    private final UpdateOrderDetailUseCase updateOrderDetailUseCase;

    public OrderDetailService(CreateOrderDetailUseCase createOrderDetailUseCase, RetrieveOrderDetailUseCase retrieveOrderDetailUseCase, DeleteOrderDetailUseCase deleteOrderDetailUseCase, UpdateOrderDetailUseCase updateOrderDetailUseCase) {
        this.createOrderDetailUseCase = createOrderDetailUseCase;
        this.retrieveOrderDetailUseCase = retrieveOrderDetailUseCase;
        this.deleteOrderDetailUseCase = deleteOrderDetailUseCase;
        this.updateOrderDetailUseCase = updateOrderDetailUseCase;
    }


    @Override
    public Boolean delete(long id) {
        return deleteOrderDetailUseCase.delete(id);
    }

    @Override
    public List<OrderDetail> findAll() {
        return retrieveOrderDetailUseCase.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(long id) {
        return retrieveOrderDetailUseCase.findById(id);
    }

    @Override
    public Optional<OrderDetail> update(long id, OrderDetail orderDetail) {
        return updateOrderDetailUseCase.update(id, orderDetail);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) throws Exception {
        return createOrderDetailUseCase.save(orderDetail);
    }
}
