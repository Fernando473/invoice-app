package com.altioracorp.evaluation.domain.ports.in.order_detail;

import com.altioracorp.evaluation.domain.models.OrderDetail;

public interface CreateOrderDetailUseCase {
    OrderDetail save(OrderDetail orderDetail) throws Exception;
}
