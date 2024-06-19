package com.altioracorp.evaluation.infrastructure.entities;


import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.models.OrderDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();


    public OrderEntity() {
    }

    public static OrderEntity fromDomainModel(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        ClientEntity clientEntity = ClientEntity.fromDomainModel(order.getClient());
        OrderDetailEntity orderDetailEntity = OrderDetailEntity.fromDomainModel(order.getOrderDetail());
        orderEntity.setClient(clientEntity);
        orderEntity.setDate(order.getDate());
        return orderEntity;
    }

    public Order toDomainModel() {
        Order order = new Order(this.orderID, this.date);
        order.setClient(this.client.toDomainModel());
        return order;
    }
}
