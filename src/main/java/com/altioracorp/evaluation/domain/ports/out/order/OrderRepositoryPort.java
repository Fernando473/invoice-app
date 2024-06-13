package com.altioracorp.evaluation.domain.ports.out.order;

import com.altioracorp.evaluation.domain.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {
    Optional<Order> findById(long id);

    List<Order> findAll();

    Optional<Order> update(long id, Order order);

    Order save(Order order);

    Boolean delete(long id);


}
