package com.microservicetutorial.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservicetutorial.orderservice.dto.OrderRequest;
import com.microservicetutorial.orderservice.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	public String createOrder(@RequestBody OrderRequest orderRequest)
	{
		orderService.createOrder(orderRequest);
		return("order placed successfully!!");
	}
	
	public String fallbackMethod(@RequestBody OrderRequest orderRequest, RuntimeException runtimeException)
	{
		return "Oops!, something went wrong!!";
	}
}
