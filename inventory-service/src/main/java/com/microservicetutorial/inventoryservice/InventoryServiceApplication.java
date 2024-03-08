package com.microservicetutorial.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservicetutorial.inventoryservice.model.Inventory;
import com.microservicetutorial.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory inventory1= new Inventory();
			inventory1.setSkucode("iphone_13");
			inventory1.setQuantity(100);
			
			
			Inventory inventory2= new Inventory();
			inventory2.setSkucode("iphone_13_red");
			inventory2.setQuantity(0);
			
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}
}
