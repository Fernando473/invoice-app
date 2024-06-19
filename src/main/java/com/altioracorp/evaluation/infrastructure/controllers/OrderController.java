package com.altioracorp.evaluation.infrastructure.controllers;

import com.altioracorp.evaluation.application.services.OrderService;
import com.altioracorp.evaluation.domain.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.allOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        try {
            Optional<Order> order = orderService.getOrder(id);
            return order.map(order_ -> new ResponseEntity<>(order_, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e){
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order orderCreated = orderService.save(order);
            return new ResponseEntity<>(orderCreated, HttpStatus.CREATED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Order>> updateOrder(@RequestBody Order order, @PathVariable Long id) {
        Optional<Order> orderUpdated = orderService.update(id, order);
        return orderUpdated.map(order_ -> new ResponseEntity<>(orderUpdated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        if (orderService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
