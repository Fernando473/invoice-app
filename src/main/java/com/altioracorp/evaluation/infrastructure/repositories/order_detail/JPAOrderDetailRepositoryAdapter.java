package com.altioracorp.evaluation.infrastructure.repositories.order_detail;

import com.altioracorp.evaluation.domain.models.OrderDetail;
import com.altioracorp.evaluation.domain.ports.out.order_detail.OrderDetailRepositoryPort;
import com.altioracorp.evaluation.infrastructure.entities.ItemEntity;
import com.altioracorp.evaluation.infrastructure.entities.OrderDetailEntity;
import com.altioracorp.evaluation.infrastructure.repositories.item.JPAItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JPAOrderDetailRepositoryAdapter implements OrderDetailRepositoryPort {
    private final JPAOrderDetailRepository jpaOrderDetailRepository;
    private final JPAItemRepository jpaItemRepository;

    public JPAOrderDetailRepositoryAdapter(JPAOrderDetailRepository jpaOrderDetailRepository, JPAItemRepository jpaItemRepository1) {
        this.jpaOrderDetailRepository = jpaOrderDetailRepository;
        this.jpaItemRepository = jpaItemRepository1;
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) throws Exception {
        OrderDetailEntity orderDetailEntity = OrderDetailEntity.fromDomainModel(orderDetail);

        ItemEntity itemEntity = orderDetailEntity.getItem();
        if (orderDetail.getQuantity() > itemEntity.getStock()) {
            throw new Exception("There is not enough items");
        }

        int newStock = itemEntity.getStock() - orderDetail.getQuantity();
        itemEntity.setStock(newStock);
        jpaItemRepository.save(itemEntity);
        OrderDetailEntity orderDetailEntityCreated = jpaOrderDetailRepository.save(orderDetailEntity);
        return orderDetailEntityCreated.toDomainModel();
    }


    @Override
    public List<OrderDetail> findAll() {
        return jpaOrderDetailRepository.findAll().stream().map(OrderDetailEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDetail> findById(long id) {
        if (jpaOrderDetailRepository.existsById(id)) {
            return jpaOrderDetailRepository.findById(id).map(OrderDetailEntity::toDomainModel);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderDetail> update(long id, OrderDetail orderDetail) {
        if (jpaOrderDetailRepository.existsById(id)) {
            OrderDetailEntity orderDetailEntity = OrderDetailEntity.fromDomainModel(orderDetail);
            OrderDetailEntity orderDetailEntityUpdated = jpaOrderDetailRepository.save(orderDetailEntity);
            return Optional.ofNullable(orderDetailEntityUpdated.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean delete(Long id) {
        if (jpaOrderDetailRepository.existsById(id)) {
            jpaOrderDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
