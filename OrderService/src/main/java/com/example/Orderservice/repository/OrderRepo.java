package com.example.Orderservice.repository;

import com.example.Orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long>{
}
