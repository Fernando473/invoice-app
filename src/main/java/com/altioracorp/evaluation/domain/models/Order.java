package com.altioracorp.evaluation.domain.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private long orderID;
    private LocalDateTime date;
    private OrderDetail orderDetail;
    private Client client;
    public Order(long orderID, LocalDateTime date) {
        this.orderID = orderID;
        this.date = date;
    }
}
