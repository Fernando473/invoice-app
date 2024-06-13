package com.altioracorp.evaluation.application.usecases.client;

import com.altioracorp.evaluation.domain.models.Client;
import com.altioracorp.evaluation.domain.ports.in.client.UpdateClientUseCase;
import com.altioracorp.evaluation.domain.ports.out.client.ClientRepositoryPort;

import java.util.Optional;

public class UpdateClientUseCaseImpl implements UpdateClientUseCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public UpdateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> update(long id, Client client) {
        return clientRepositoryPort.update(id,client);
    }
}
