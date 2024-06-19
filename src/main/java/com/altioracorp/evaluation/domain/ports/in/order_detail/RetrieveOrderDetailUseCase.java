package com.altioracorp.evaluation.domain.ports.in.order_detail;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface RetrieveOrderDetailUseCase {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(long id);
}
