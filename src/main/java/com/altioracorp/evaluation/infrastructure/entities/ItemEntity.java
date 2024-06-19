package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Item;
import com.altioracorp.evaluation.domain.models.OrderDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemCode;
    private String itemName;
    private Double price;
    private int stock;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();

    public ItemEntity() {

    }

    public static ItemEntity fromDomainModel(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemName(item.getItemName());
        itemEntity.setPrice(item.getPrice());
        itemEntity.setStock(item.getStock());
        return itemEntity;
    }

    public Item toDomainModel() {
        return new Item(this.itemCode, this.itemName, this.price, this.stock);
    }

}
