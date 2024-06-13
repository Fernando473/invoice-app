package com.altioracorp.evaluation.infrastructure.config;

import com.altioracorp.evaluation.application.services.ClientService;
import com.altioracorp.evaluation.application.services.ItemService;
import com.altioracorp.evaluation.application.services.OrderService;
import com.altioracorp.evaluation.application.usecases.client.CreateClientUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.client.DeleteClientUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.client.RetrieveClientUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.client.UpdateClientUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.item.CreateItemUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.item.DeleteItemUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.item.RetrieveItemUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.item.UpdateItemUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.order.CreateOrderUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.order.DeleteOrderUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.order.RetrieveOrderUseCaseImpl;
import com.altioracorp.evaluation.application.usecases.order.UpdateOrderUseCaseImpl;
import com.altioracorp.evaluation.domain.ports.out.client.ClientRepositoryPort;
import com.altioracorp.evaluation.domain.ports.out.item.ItemRepositoryPort;
import com.altioracorp.evaluation.domain.ports.out.order.OrderRepositoryPort;
import com.altioracorp.evaluation.infrastructure.repositories.client.JPAClientRepositoryAdapter;
import com.altioracorp.evaluation.infrastructure.repositories.item.JPAItemRepositoryAdapter;
import com.altioracorp.evaluation.infrastructure.repositories.order.JPAOrderRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ClientService clientService(ClientRepositoryPort clientRepositoryPort) {
        return new ClientService(
                new CreateClientUseCaseImpl(clientRepositoryPort),
                new RetrieveClientUseCaseImpl(clientRepositoryPort),
                new DeleteClientUseCaseImpl(clientRepositoryPort),
                new UpdateClientUseCaseImpl(clientRepositoryPort));
    }

    @Bean
    public ClientRepositoryPort clientRepositoryPort(JPAClientRepositoryAdapter jpaClientRepositoryAdapter) {
        return jpaClientRepositoryAdapter;
    }

    @Bean
    public ItemService itemService(ItemRepositoryPort itemRepositoryPort) {
        return new ItemService(
                new CreateItemUseCaseImpl(itemRepositoryPort),
                new UpdateItemUseCaseImpl(itemRepositoryPort),
                new RetrieveItemUseCaseImpl(itemRepositoryPort),
                new DeleteItemUseCaseImpl(itemRepositoryPort)
        );
    }

    @Bean
    public ItemRepositoryPort itemRepositoryPort(JPAItemRepositoryAdapter jpaItemRepositoryAdapter) {
        return jpaItemRepositoryAdapter;
    }

    @Bean
    public OrderService orderService(OrderRepositoryPort orderRepositoryPort){
        return new OrderService(
                new CreateOrderUseCaseImpl(orderRepositoryPort),
                new RetrieveOrderUseCaseImpl(orderRepositoryPort),
                new DeleteOrderUseCaseImpl(orderRepositoryPort),
                new UpdateOrderUseCaseImpl(orderRepositoryPort)
        );
    }


    @Bean
    public OrderRepositoryPort orderRepositoryPort(JPAOrderRepositoryAdapter jpaOrderRepositoryAdapter){
        return jpaOrderRepositoryAdapter;
    }


}
