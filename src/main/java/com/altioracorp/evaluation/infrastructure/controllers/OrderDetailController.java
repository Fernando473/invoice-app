package com.altioracorp.evaluation.infrastructure.controllers;

import com.altioracorp.evaluation.application.services.OrderDetailService;
import com.altioracorp.evaluation.domain.models.OrderDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/order-details")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) throws Exception{
        OrderDetail orderDetailCreated = orderDetailService.save(orderDetail);
        return new ResponseEntity<>(orderDetailCreated, HttpStatus.CREATED);
    }
}
