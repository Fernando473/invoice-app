package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.models.OrderDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@AllArgsConstructor
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemEntity item;


    public OrderDetailEntity() {
    }

    public static OrderDetailEntity fromDomainModel(OrderDetail orderDetail) {
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        ItemEntity itemEntity = ItemEntity.fromDomainModel(orderDetail.getItem());
        OrderEntity orderEntity = OrderEntity.fromDomainModel(orderDetail.getOrder());
        orderDetailEntity.setOrder(orderEntity);
        orderDetailEntity.setItem(itemEntity);
        orderDetailEntity.setQuantity(orderDetail.getQuantity());
        return orderDetailEntity;
    }

    public OrderDetail toDomainModel() {
        OrderDetail orderDetail = new OrderDetail();
        Order order = this.order.toDomainModel();
        Item item = this.item.toDomainModel();
        orderDetail.setQuantity(this.quantity);
        orderDetail.setOrder(order);
        orderDetail.setItem(item);
        return orderDetail;
    }
}
