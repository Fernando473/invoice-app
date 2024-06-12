package com.altioracorp.evaluation.domain.ports.out.client;

import com.altioracorp.evaluation.domain.models.Client;

import java.util.Optional;
import java.util.List;

public interface ExternalRepositoryPort {
    Client save(Client task);
    Optional<Client> findById(long id);
    List<Client> findAll();
    Optional<Client> update(Client client);
}
