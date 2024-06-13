package com.altioracorp.evaluation.application.services;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.ports.in.order.CreateOrderUseCase;
import com.altioracorp.evaluation.domain.ports.in.order.DeleteOrderUseCase;
import com.altioracorp.evaluation.domain.ports.in.order.RetrieveOrderUseCase;
import com.altioracorp.evaluation.domain.ports.in.order.UpdateOrderUseCase;

import java.util.List;
import java.util.Optional;

public class OrderService implements CreateOrderUseCase, RetrieveOrderUseCase, DeleteOrderUseCase, UpdateOrderUseCase {
    private final CreateOrderUseCase createOrder;
    private final RetrieveOrderUseCase retrieveOrder;
    private final DeleteOrderUseCase deleteOrder;

    private final UpdateOrderUseCase updateOrder;

    public OrderService(CreateOrderUseCase createOrder, RetrieveOrderUseCase retrieveOrder, DeleteOrderUseCase deleteOrder, UpdateOrderUseCase updateOrder) {
        this.createOrder = createOrder;
        this.retrieveOrder = retrieveOrder;
        this.deleteOrder = deleteOrder;
        this.updateOrder = updateOrder;
    }

    @Override
    public Order save(Order order) {
        return createOrder.save(order);
    }

    @Override
    public Optional<Order> getOrder(long orderId) {
        return retrieveOrder.getOrder(orderId);
    }

    @Override
    public List<Order> allOrders() {
        return retrieveOrder.allOrders();
    }

    @Override
    public boolean delete(long id) {
        return deleteOrder.delete(id);
    }

    @Override
    public Optional<Order> update(long id, Order order) {
        return updateOrder.update(id, order);
    }
}
