package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public String findProductByIdAsString(int pid) {
		Optional<Product> result =productRepository.findById(pid);
		if(result.isPresent()) {
			Product p=result.get();
			return p.toString();
		}else {
			return "Product not Present";
		}
	}
	
	public Product findProductByIdAsObject(int pid) {
		Optional<Product> result =productRepository.findById(pid);
		if(result.isPresent()) {
			Product p=result.get();
			return p;
		}else {
			return null;
		}
	}
}
