package com.microservicetutorial.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicetutorial.productservice.dto.ProductRequest;
import com.microservicetutorial.productservice.dto.ProductResponse;
import com.microservicetutorial.productservice.model.Product;
import com.microservicetutorial.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	@Autowired
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest)
	{
		Product product=Product.builder().
				name(productRequest.getName()).
				desc(productRequest.getDesc()).
				price(productRequest.getPrice()).build();
		
		productRepository.save(product);
		
		log.info("Product with productId {} is saved", product.getName());
	}

	public List<ProductResponse> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> lists= productRepository.findAll();
		
		return (lists.stream().map(x-> mapToProductResponse(x)).collect(Collectors.toList()));
	}

	private ProductResponse mapToProductResponse(Product product) {
		// TODO Auto-generated method stub
		return ProductResponse.builder().
				id(product.getId()).
				name(product.getName()).
				desc(product.getDesc()).
				price(product.getPrice()).build();
	}

}
