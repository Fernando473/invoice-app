package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.models.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue()
    private long id;

    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemEntity> items = new ArrayList<>();

    public OrderEntity() {
    }

    public static OrderEntity fromDomainModel(Order order) {
        List<ItemEntity> itemEntities = order.getItems().stream()
                .map(ItemEntity::fromDomainModel)
                .collect(Collectors.toList());
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getOrderID());
        orderEntity.setItems(itemEntities);
        orderEntity.setDate(order.getDate());
        return orderEntity;
    }

    public Order toDomainModel() {
        List<Item> items = this.getItems().stream()
                .map(ItemEntity::toDomainModel)
                .toList();
        return new Order(this.getId(), this.getDate(), items);
    }
}
