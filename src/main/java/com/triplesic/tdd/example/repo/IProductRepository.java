package com.triplesic.tdd.example.repo;

import com.triplesic.tdd.example.model.Product;

import java.util.List;

public interface IProductRepository {

    public boolean hasProduct(String product);

    public List<Product> getAllProduct();

}