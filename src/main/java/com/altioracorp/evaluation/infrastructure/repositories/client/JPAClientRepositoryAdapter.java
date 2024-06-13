package com.altioracorp.evaluation.infrastructure.repositories.client;

import com.altioracorp.evaluation.domain.models.Client;
import com.altioracorp.evaluation.domain.ports.out.client.ClientRepositoryPort;
import com.altioracorp.evaluation.infrastructure.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JPAClientRepositoryAdapter implements ClientRepositoryPort {
    private final JPAClientRepository jpaClientRepository;

    public JPAClientRepositoryAdapter(JPAClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = ClientEntity.fromDomainModel(client);
        ClientEntity clientEntitySaved = jpaClientRepository.save(clientEntity);
        return clientEntitySaved.toDomainModel();
    }

    @Override
    public Optional<Client> findById(long id) {
        return jpaClientRepository.findById(id).map(ClientEntity::toDomainModel);
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll().stream().map(ClientEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Client> update(long id, Client client) {
        if (jpaClientRepository.existsById(id)) {
            ClientEntity clientEntity = ClientEntity.fromDomainModel(client);
            ClientEntity clientEntityUpdated = jpaClientRepository.save(clientEntity);
            return Optional.of(clientEntityUpdated.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean delelteById(long id) {
        if (jpaClientRepository.existsById(id)) {
            jpaClientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
