package com.altioracorp.evaluation.application.usecases.client;

import com.altioracorp.evaluation.domain.models.Client;
import com.altioracorp.evaluation.domain.ports.in.client.CreateIClientUseCase;
import com.altioracorp.evaluation.domain.ports.out.client.ClientRepositoryPort;

public class CreateClientUseCaseImpl implements CreateIClientUseCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public CreateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepositoryPort.save(client);
    }
}
