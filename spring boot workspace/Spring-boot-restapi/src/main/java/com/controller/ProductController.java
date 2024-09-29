package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService prodcutService;
	
	// http://localhost:8080/find_products
	@RequestMapping(value = "find_products",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProducts(){
		return prodcutService.findAllProducts();
	}
}
