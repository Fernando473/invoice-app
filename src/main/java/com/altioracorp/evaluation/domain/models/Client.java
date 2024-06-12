package com.altioracorp.evaluation.domain.models;

import lombok.Data;

@Data

public class Client {
    private long id;
    private String name;
    private String lastName;

    public Client(long id, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }
}
