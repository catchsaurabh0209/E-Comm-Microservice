package com.microservicetutorial.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicetutorial.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
