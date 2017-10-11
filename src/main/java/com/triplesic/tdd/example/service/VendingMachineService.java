package com.triplesic.tdd.example.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplesic.tdd.example.repo.ProductRepo;

@Service
public class VendingMachineService {

	ProductRepo productRepo = new ProductRepo();
	
	public Map<String, Object> buyProduct(String string, long l) {

		Map<String, Object> expected = new HashMap<>();

		expected.put("product", null);
		expected.put("exchange", Arrays.asList(15L));
		expected.put("message", "Sorry! no product");

		return expected;
	}
	
	public Map<String, Object> buyProduct2(String string, long l) {

		boolean hasProduct = hasProduct(string);
		
		Map<String, Object> expected = new HashMap<>();
		
		if(hasProduct){
			expected.put("product", string);
			expected.put("exchange", null);
			expected.put("message", "Thank you!");
		}else{
			expected.put("product", null);
			expected.put("exchange", Arrays.asList(15L));
			expected.put("message", "Sorry! no product");
		}

		return expected;
	}

	private boolean hasProduct(String product){
		return productRepo.hasProduct(product);
	}
}
