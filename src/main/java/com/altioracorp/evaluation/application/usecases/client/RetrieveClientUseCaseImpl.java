package com.altioracorp.evaluation.application.usecases.client;

import com.altioracorp.evaluation.domain.models.Client;
import com.altioracorp.evaluation.domain.ports.in.client.RetrieveIClientUseCase;
import com.altioracorp.evaluation.domain.ports.out.client.ClientRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveClientUseCaseImpl implements RetrieveIClientUseCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public RetrieveClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> getClient(long id) {
        return clientRepositoryPort.findById(id);
    }

    @Override
    public List<Client> allClients() {
        return clientRepositoryPort.findAll();
    }
}
