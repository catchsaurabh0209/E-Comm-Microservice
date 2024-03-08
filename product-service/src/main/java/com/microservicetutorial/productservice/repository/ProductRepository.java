package com.microservicetutorial.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservicetutorial.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
