package com.microservicetutorial.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservicetutorial.inventoryservice.dto.InventoryResponse;
import com.microservicetutorial.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	
	private final InventoryService inventoryService;
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isAvailable(@RequestParam(name = "skucode") List<String> skuCode)
	{
		return inventoryService.isInStock(skuCode);
	}

}
