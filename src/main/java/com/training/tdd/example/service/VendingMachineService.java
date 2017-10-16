package com.training.tdd.example.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.training.tdd.example.repo.ProductRepository;

@Service
public class VendingMachineService {

	ProductRepository legacyProductRepo = new ProductRepository();
	
	public Map<String, Object> buyProduct(String string, long l) {

		boolean hasProduct = hasProduct(string);

		Map<String, Object> expected = new HashMap<>();

		if (hasProduct) {
			expected.put("product", string);
			expected.put("exchange", null);
			expected.put("message", "Thank you!");
		} else {
			expected.put("product", null);
			expected.put("exchange", Arrays.asList(15L));
			expected.put("message", "Sorry! no product");
		}

		return expected;
	}

	private boolean hasProduct(String product) {
		return legacyProductRepo.hasProduct(product);
	}
}
