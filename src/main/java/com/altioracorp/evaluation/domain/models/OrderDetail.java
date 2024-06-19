package com.altioracorp.evaluation.domain.models;

import lombok.Data;


@Data
public class OrderDetail {
    private Order order;
    private Item item;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Item item, int quantity) {
        this.item = item;
        this.order = order;
        this.quantity = quantity;
    }

}
