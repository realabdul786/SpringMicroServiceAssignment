package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.Product;
import com.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	public String create(Product p)
	{
		Optional<Product> fetchedprod =  repo.findById(p.getPid());
		if(fetchedprod.isPresent())
		{
			return "product already exists";
		}
		else
		{
			repo.save(p);
			return "Product saved successfully";
		}
	
	}
	
	public Product getProductById(int id)
	{
		Optional<Product> fetchedprod =  repo.findById(id);
		if(fetchedprod.isPresent()) {
			return fetchedprod.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Product> getAllPoduct(){
		return repo.findAll();
	}
	
	public int getPIdByName(String pname)
	{
		int pid = -1;
		for(Product p:getAllPoduct())
		{
			if(p.getPname().equalsIgnoreCase(pname))
				pid = p.getPid();
		}
		return pid;
	}
}
