package com.microservicetutorial.orderservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	private List<OrderLineItemsDto> orderLineItemsDto;

}
