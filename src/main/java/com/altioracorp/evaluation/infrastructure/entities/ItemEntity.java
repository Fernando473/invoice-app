package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemCode;
    private String itemName;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public ItemEntity() {

    }

    public static ItemEntity fromDomainModel(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemName(item.getItemName());
        itemEntity.setPrice(item.getPrice());
        return itemEntity;
    }

    public Item toDomainModel() {
        return new Item(this.itemCode, this.itemName, this.price);
    }

}
