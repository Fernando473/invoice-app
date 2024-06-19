package com.altioracorp.evaluation.domain.ports.in.order_detail;

import com.altioracorp.evaluation.domain.models.OrderDetail;

import java.util.Optional;

public interface UpdateOrderDetailUseCase {
    Optional<OrderDetail> update(long id, OrderDetail orderDetail);
}
