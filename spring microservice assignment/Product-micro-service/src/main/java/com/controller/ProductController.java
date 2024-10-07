package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collection.Product;
import com.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping(value = "products", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createProd(@RequestBody Product prod  ) {
		return service.create(prod);
	}
	
	@GetMapping(value = "products/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getProductById(@PathVariable("pid") int id)
	{
		Product p = service.getProductById(id);
		if(p == null)
			return "Product not found";
		return p;
	}
	
	@GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Product> getAllProds(){
		return service.getAllPoduct();
	}
	
	@GetMapping(value = "productsbyname/{pname}")
	public int getpIdByName(@PathVariable("pname") String pname)
	{
		return service.getPIdByName(pname);
	}
	
	
}
