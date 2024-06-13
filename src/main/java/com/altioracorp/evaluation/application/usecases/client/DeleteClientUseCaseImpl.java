package com.altioracorp.evaluation.application.usecases.client;

import com.altioracorp.evaluation.domain.ports.in.client.DeleteClientUseCase;
import com.altioracorp.evaluation.domain.ports.out.client.ClientRepositoryPort;

public class DeleteClientUseCaseImpl implements DeleteClientUseCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public DeleteClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public boolean delete(long id) {
        return clientRepositoryPort.delelteById(id);
    }
}
