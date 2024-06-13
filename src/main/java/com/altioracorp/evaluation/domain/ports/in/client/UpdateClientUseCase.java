package com.altioracorp.evaluation.domain.ports.in.client;

import com.altioracorp.evaluation.domain.models.Client;

import java.util.Optional;

public interface UpdateClientUseCase {
    Optional<Client> update(long id, Client client);
}
