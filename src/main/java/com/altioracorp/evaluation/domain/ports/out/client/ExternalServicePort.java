package com.altioracorp.evaluation.domain.ports.out.client;

import com.altioracorp.evaluation.domain.models.Client;

import java.util.Optional;

public interface ExternalServicePort {
    Optional<Client> getClient(long id);
}
