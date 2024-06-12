package com.altioracorp.evaluation.domain.models;


import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class Order {
    private long orderID;
    private LocalDateTime date;

    public Order(long orderID, LocalDateTime date) {
        this.orderID = orderID;
        this.date = date;
    }
}
