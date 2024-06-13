package com.altioracorp.evaluation.infrastructure.repositories.order;

import com.altioracorp.evaluation.domain.models.Order;
import com.altioracorp.evaluation.domain.ports.out.order.OrderRepositoryPort;
import com.altioracorp.evaluation.infrastructure.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JPAOrderRepositoryAdapter implements OrderRepositoryPort {
    private final JPAOrderRepository jpaOrderRepository;

    public JPAOrderRepositoryAdapter(JPAOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }


    @Override
    public Optional<Order> findById(long id) {
        return jpaOrderRepository.findById(id).map(OrderEntity::toDomainModel);
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll().stream().map(OrderEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Order> update(long id, Order order) {
        if (jpaOrderRepository.existsById(id)) {
            OrderEntity orderEntity = OrderEntity.fromDomainModel(order);
            OrderEntity orderEntityUpdated = jpaOrderRepository.save(orderEntity);
            return Optional.ofNullable(orderEntityUpdated.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = OrderEntity.fromDomainModel(order);
        OrderEntity orderEntityCreated = jpaOrderRepository.save(orderEntity);
        return orderEntityCreated.toDomainModel();
    }

    @Override
    public Boolean delete(long id) {
        if (jpaOrderRepository.existsById(id)) {
            jpaOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
