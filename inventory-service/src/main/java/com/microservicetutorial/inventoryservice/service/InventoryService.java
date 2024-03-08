package com.microservicetutorial.inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicetutorial.inventoryservice.dto.InventoryResponse;
import com.microservicetutorial.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	private final InventoryRepository inventoryRepository;
	
	@Transactional(readOnly=true)
	public List<InventoryResponse> isInStock(List<String> skuCode)
	{
		return (inventoryRepository.findBySkucodeIn(skuCode).stream().
				map(x-> InventoryResponse.builder().skucode(x.getSkucode()).isInStock(x.getQuantity()>0).build()).toList());
	}
}
