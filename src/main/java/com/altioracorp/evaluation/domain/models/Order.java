package com.altioracorp.evaluation.domain.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private long orderID;
    private LocalDateTime date;
    private List<Item> items;

    public Order(long orderID, LocalDateTime date, List<Item> items) {
        this.orderID = orderID;
        this.date = date;
        this.items = items;
    }
}
