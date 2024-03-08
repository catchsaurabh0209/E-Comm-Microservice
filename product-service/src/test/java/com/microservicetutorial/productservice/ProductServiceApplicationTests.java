package com.microservicetutorial.productservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicetutorial.productservice.dto.ProductRequest;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertryRegistry)
	{
		dynamicPropertryRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws JsonProcessingException, Exception {
		
		ProductRequest productRequest = getProductRequest();
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/").
				contentType(org.springframework.http.MediaType.APPLICATION_JSON).
				content(objectMapper.writeValueAsString(productRequest))).andExpect(status().isCreated());
		
	}
	private ProductRequest getProductRequest()
	{
		return ProductRequest.builder().
		name("Iphone 15").
		desc("Iphone 15").
		price(BigDecimal.valueOf(1200)).build();

	}
}