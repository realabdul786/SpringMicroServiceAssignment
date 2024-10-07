package com.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.helperEntity.Product;


@FeignClient(name = "PRODUCT-MICRO-SERVICE")
public interface ProductFeignService {

	@GetMapping(value = "product/products/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getProductById(@PathVariable("pid") int id);
	
	@GetMapping(value = "product/products", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Product> getAllProds();
	
	@GetMapping(value = "product/productsbyname/{pname}")
	public int getpIdByName(@PathVariable("pname") String pname);
	
}
