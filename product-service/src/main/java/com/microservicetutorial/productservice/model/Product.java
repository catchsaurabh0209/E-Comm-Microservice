package com.microservicetutorial.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value="product")
public class Product {
	@Id
	private String id;
	private String name;
	private String desc;
	
	private BigDecimal price;
	

}
