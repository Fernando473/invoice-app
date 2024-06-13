package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.models.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<ItemEntity> items = new ArrayList<>();

    public OrderEntity() {
    }

    public static OrderEntity fromDomainModel(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        List<Item> items = order.getItems() != null ? order.getItems() : Collections.emptyList();
        orderEntity.items = items.stream().map(ItemEntity::fromDomainModel).collect(Collectors.toList());
        orderEntity.setDate(order.getDate());
        return orderEntity;
    }


    public Order toDomainModel() {
        List<Item> items = this.getItems().stream().map(ItemEntity::toDomainModel).collect(Collectors.toList());
        return new Order(this.orderID, this.date, items);
    }
}
