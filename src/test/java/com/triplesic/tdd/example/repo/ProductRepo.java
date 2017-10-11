package com.triplesic.tdd.example.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.triplesic.tdd.example.model.Product;

@Component
public class ProductRepo {

	//Database representation
	
	public boolean hasProduct(String product) {
		Random rand = new Random();
		return rand.nextBoolean(); 
	}
	
	public List<Product> getAllProduct(){
		List<Product> productList = new ArrayList<>();
		
		productList.add(new Product("Coke", 12L));
		productList.add(new Product("Instant Noodle", 6L));
		productList.add(new Product("Lay", 10L));
		
		return productList;
	}
}
