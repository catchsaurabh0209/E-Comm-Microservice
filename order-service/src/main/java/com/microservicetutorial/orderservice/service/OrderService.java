package com.microservicetutorial.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservicetutorial.orderservice.dto.InventoryResponse;
import com.microservicetutorial.orderservice.dto.OrderLineItemsDto;
import com.microservicetutorial.orderservice.dto.OrderRequest;
import com.microservicetutorial.orderservice.event.OrderPlacedEvent;
import com.microservicetutorial.orderservice.model.Order;
import com.microservicetutorial.orderservice.model.OrderLineItems;
import com.microservicetutorial.orderservice.repository.OrderRepository;


@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
	
	public void createOrder(OrderRequest orderRequest)
	{
		Order order= new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems>orderLineItemsList= orderRequest.getOrderLineItemsDto().stream().map(x-> mapToDto(x)).collect(Collectors.toList());
		order.setOrderLineItems(orderLineItemsList);
		
		//This will passed while calling inventory as request param.
		List<String> skucodes = orderLineItemsList.stream().map(x-> x.getSkucode()).toList();
		
		// Call inventory service to check if the product is in stock.
		// Save in the case of stock availability.
		
		InventoryResponse[] inventoryResponse=webClientBuilder.build().get().uri("http://inventory-service/api/inventory/",
				uriBuilder-> uriBuilder.queryParam("skucode", skucodes).build())
				.retrieve().bodyToMono(InventoryResponse[].class).block();
		
		boolean result = Arrays.stream(inventoryResponse).allMatch(x->x.isInStock());
		if(result==true)
		{
			orderRepository.save(order);
			kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
		}
		else
			throw new IllegalArgumentException("Product not in stock!!");
	}
	
	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto)
	{
		OrderLineItems orderLineItems= new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkucode(orderLineItemsDto.getSkucode());
		
		return orderLineItems;
	}

}
