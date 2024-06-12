package com.altioracorp.evaluation.domain.ports.in.client;


import com.altioracorp.evaluation.domain.models.Client;

import java.util.List;
import java.util.Optional;

public interface RetrieveIClientUseCase {
    Optional<Client> getClient(long id);

    List<Client> allClients();
}
