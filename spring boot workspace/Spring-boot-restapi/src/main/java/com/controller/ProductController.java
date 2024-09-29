package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	// http://localhost:8080/find_products
	@RequestMapping(value = "find_products",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProducts(){
		return productService.findAllProducts();
	}
	
	// http://localhost:8080/find_product_by_id/1		method is get with path param 
	
		@RequestMapping(value = "find_product_by_id/{id}",method = RequestMethod.GET)
		public String findProductById(@PathVariable("id") int pid) {
			return productService.findProductByIdAsString(pid);
		}
		
		// http://localhost:8080/find_product_by_id_object/1		method is get with path param 
		
		@RequestMapping(value = "find_product_by_id_object/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public Product findProductByIdReturnProduct(@PathVariable("id") int pid) {
				return productService.findProductByIdAsObject(pid);
		}
		
		// http://localhost:8080/store_product
		
		@RequestMapping(value = "store_product",method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public String storeProduct(@RequestBody Product product) {	// ready to receive 
			//System.out.println(product);		// @RequestBody annotation is use to extract json data from body 
			//return "Post method called.";
			return productService.storeProduct(product);
		}
}
