package com.altioracorp.evaluation.domain.ports.in.client;

import com.altioracorp.evaluation.domain.models.Client;

public interface CreateIClientUseCase {
    Client createClient(Client client);
}
