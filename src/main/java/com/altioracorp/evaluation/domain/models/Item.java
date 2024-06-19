package com.altioracorp.evaluation.domain.models;

import lombok.Data;

@Data
public class Item {
    private long itemCode;
    private String itemName;
    private Double price;
    private int stock;
    private OrderDetail orderDetail;

    public Item(long itemCode, String item_name, Double price, int stock) {
        this.itemCode = itemCode;
        this.itemName = item_name;
        this.price = price;
        this.stock = stock;
    }
}
