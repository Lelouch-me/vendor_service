package com.practice.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import com.practice.product_service.model.Product;
import com.practice.product_service.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public void createProduct(ProductRequest productRequest) {
		Product product = new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
		productRepo.save(product);
		System.out.println("Product "+product.getId()+ " is saved.");
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepo.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		ProductResponse productResponse = new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
		return  productResponse ;
	}
}
