package com.microservicetutorial.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
	private String id;
	private String name;
	private String desc;
	private BigDecimal price;
}
