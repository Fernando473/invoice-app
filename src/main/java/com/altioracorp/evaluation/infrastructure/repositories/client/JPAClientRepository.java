package com.altioracorp.evaluation.infrastructure.repositories.client;

import com.altioracorp.evaluation.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAClientRepository extends JpaRepository<ClientEntity, Long> {
}
