package com.altioracorp.evaluation.domain.ports.out.client;

import com.altioracorp.evaluation.domain.models.Client;

import java.util.Optional;
import java.util.List;


public interface ClientRepositoryPort {
    Client save(Client client);

    Optional<Client> findById(long id);

    List<Client> findAll();

    Optional<Client> update(long id, Client client);

    boolean delelteById(long id);
}
