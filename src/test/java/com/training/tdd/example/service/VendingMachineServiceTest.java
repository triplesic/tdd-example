package com.training.tdd.example.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.tdd.example.repo.ProductRepository;
import com.training.tdd.example.service.VendingMachineService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendingMachineServiceTest {

	@InjectMocks
	VendingMachineService vendingMachineService;

	@Mock
	ProductRepository legacyProductRepo;

	@Test
	public void shouldReturnMessageNoProductAndExchangeAllMoneyWhenNoItemInVendingMachine() {

		Mockito.doReturn(false).when(legacyProductRepo).hasProduct("Coke");

		Map<String, Object> result = vendingMachineService.buyProduct("Coke", 12L);
		Map<String, Object> expected = new HashMap<>();

		expected.put("product", null);
		expected.put("exchange", Arrays.asList(15L));
		expected.put("message", "Sorry! no product");

		Assert.assertEquals(expected, result);
	}

	@Test
	public void shouldReturnCokeAndThankyouMsgWhenSelectCodeAndInsertEnoughMoney() {

		Mockito.doReturn(true).when(legacyProductRepo).hasProduct("Coke");

		Map<String, Object> result = vendingMachineService.buyProduct("Coke", 12L);
		Map<String, Object> expected = new HashMap<>();

		expected.put("product", "Coke");
		expected.put("exchange", null);
		expected.put("message", "Thank you!");

		Assert.assertEquals(expected, result);
	}
}
