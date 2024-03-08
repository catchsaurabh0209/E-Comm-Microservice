package com.microservicetutorial.orderservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
	private String skucode;
	private BigDecimal price;
	private Integer quantity;

}
