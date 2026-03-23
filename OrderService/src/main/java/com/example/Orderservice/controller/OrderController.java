package com.example.Orderservice.controller;

import com.example.Orderservice.model.Order;
import com.example.Orderservice.service.OrderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
}
