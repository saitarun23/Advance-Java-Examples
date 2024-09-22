package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage() {
		
		return "index";
	}
	
	@RequestMapping(value = "addPage",method = RequestMethod.GET)
	public String addProductPage(Model mm, Product pp) {
		mm.addAttribute("product", pp);
		return "addProduct";
	}
	
	@RequestMapping(value = "addProductInDb",method = RequestMethod.POST)
	public String addProductInDb(Model mm, Product pp) {
		String result = productService.storeProduct(pp);
		pp.setPid(0);
		pp.setPname("");
		pp.setPrice(0.0f);
		pp.setQty(0);
		mm.addAttribute("product", pp);
		mm.addAttribute("result", result);
		return "addProduct";
	}
}
