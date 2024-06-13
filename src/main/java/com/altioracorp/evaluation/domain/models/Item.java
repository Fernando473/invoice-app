package com.altioracorp.evaluation.domain.models;

import lombok.Data;

@Data
public class Item {
    private long itemCode;
    private String itemName;
    private Double price;

    public Item(long item_code, String item_name, Double price) {
        this.itemCode = item_code;
        this.itemName = item_name;
        this.price = price;
    }
}
