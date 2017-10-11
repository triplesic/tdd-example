package com.triplesic.tdd.example.model;

public class Product {

	private String name;
	private Long price;

	public Product() {
		super();
	}

	public Product(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
