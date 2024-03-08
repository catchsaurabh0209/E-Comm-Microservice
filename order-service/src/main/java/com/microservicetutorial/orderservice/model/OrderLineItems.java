package com.microservicetutorial.orderservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_orderLineItems")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String skucode;
	private BigDecimal price;
	private Integer quantity;

}
