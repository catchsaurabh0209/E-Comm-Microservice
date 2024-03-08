package com.microservicetutorial.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
	
	private String skucode;
	private boolean isInStock;

}
