package com.practice.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.product_service.model.Product;

public interface ProductRepo extends MongoRepository<Product, String>{

}
