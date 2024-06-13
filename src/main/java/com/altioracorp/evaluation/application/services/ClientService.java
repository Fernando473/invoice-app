package com.altioracorp.evaluation.application.services;

import com.altioracorp.evaluation.domain.models.Client;
import com.altioracorp.evaluation.domain.ports.in.client.CreateIClientUseCase;
import com.altioracorp.evaluation.domain.ports.in.client.DeleteClientUseCase;
import com.altioracorp.evaluation.domain.ports.in.client.RetrieveIClientUseCase;
import com.altioracorp.evaluation.domain.ports.in.client.UpdateClientUseCase;

import java.util.List;
import java.util.Optional;

public class ClientService implements CreateIClientUseCase, RetrieveIClientUseCase, DeleteClientUseCase, UpdateClientUseCase {
    private final CreateIClientUseCase createIClientUseCase;
    private final RetrieveIClientUseCase retrieveIClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;

    public ClientService(CreateIClientUseCase createIClientUseCase, RetrieveIClientUseCase retrieveIClientUseCase, DeleteClientUseCase deleteClientUseCase, UpdateClientUseCase updateClientUseCase) {
        this.createIClientUseCase = createIClientUseCase;
        this.retrieveIClientUseCase = retrieveIClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
    }

    @Override
    public Client createClient(Client client) {
        return createIClientUseCase.createClient(client);
    }

    @Override
    public boolean delete(long id) {
        return deleteClientUseCase.delete(id);
    }

    @Override
    public Optional<Client> getClient(long id) {
        return retrieveIClientUseCase.getClient(id);
    }

    @Override
    public List<Client> allClients() {
        return retrieveIClientUseCase.allClients();
    }

    @Override
    public Optional<Client> update(long id, Client client) {
        return updateClientUseCase.update(id, client);
    }
}
