package com.example.Orderservice.service.impl;

import com.example.Orderservice.model.Order;
import com.example.Orderservice.repository.OrderRepo;
import com.example.Orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    @Override
    public Order placeOrder(Order order){
        return orderRepo.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id){
        return orderRepo.findById(id);
    }

}
