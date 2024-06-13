package com.altioracorp.evaluation.domain.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Client {
    private long id;
    private String firstName;
    private String lastName;
    private List<Order> orders = new ArrayList<>();

    public Client(long id, String firstName, String lastName, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.orders = orders;
    }
}
