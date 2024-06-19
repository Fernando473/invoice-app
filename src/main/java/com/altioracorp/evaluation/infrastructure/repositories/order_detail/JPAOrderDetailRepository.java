package com.altioracorp.evaluation.infrastructure.repositories.order_detail;

import com.altioracorp.evaluation.infrastructure.entities.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAOrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}
