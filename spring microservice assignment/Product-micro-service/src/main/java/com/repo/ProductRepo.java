package com.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collection.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product , Integer>{

}
