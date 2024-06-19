package com.altioracorp.evaluation.domain.ports.out.order_detail;

import com.altioracorp.evaluation.domain.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepositoryPort {

    OrderDetail save(OrderDetail orderDetail) throws Exception;
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(long id);

    Optional<OrderDetail> update(long id, OrderDetail orderDetail);

    Boolean delete(Long id);
}
