package com.example.Orderservice.service;

import com.example.Orderservice.model.Order;

import java.util.Optional;

public interface OrderService {
    Order placeOrder(Order order);

    Optional<Order> getOrderById(Long id);
}
