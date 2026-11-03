package com.chauhan.in.orderservice.repository;


import com.chauhan.in.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Long> {
}
