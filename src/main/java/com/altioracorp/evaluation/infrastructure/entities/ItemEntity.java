package com.altioracorp.evaluation.infrastructure.entities;

import com.altioracorp.evaluation.domain.models.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public ItemEntity() {

    }

    public static ItemEntity fromDomainModel(Item item) {
        return new ItemEntity(item.getItemCode(), item.getItemName(), item.getPrice());
    }

    public Item toDomainModel() {
        return new Item(this.itemCode, this.itemName, this.price);
    }

}
