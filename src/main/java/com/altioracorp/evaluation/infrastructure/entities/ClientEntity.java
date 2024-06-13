package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Client;
import com.altioracorp.evaluation.domain.models.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders = new ArrayList<>();

    public ClientEntity() {
    }

    public static ClientEntity fromDomainModel(Client client) {
        List<OrderEntity> orderEntities = client.getOrders().stream()
                .map(OrderEntity::fromDomainModel)
                .collect(Collectors.toList());
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName(client.getFirstName());
        clientEntity.setLastName(client.getLastName());
        clientEntity.setOrders(orderEntities);
        return clientEntity;
    }

    public Client toDomainModel() {
        List<Order> orders = this.getOrders().stream()
                .map(OrderEntity::toDomainModel)
                .collect(Collectors.toList());
        return new Client(this.id, this.firstName, this.lastName, orders);
    }
}
