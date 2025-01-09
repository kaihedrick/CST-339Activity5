package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.OrdersBusinessService;

import com.gcu.model.OrderModel;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrdersBusinessService orders;

    @Autowired
    public OrderController(OrdersBusinessService orders) {
        this.orders = orders;
    }

    @GetMapping
    public List<OrderModel> getOrders() {
        return orders.getOrders();
    }
}

