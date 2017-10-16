package com.training.tdd.example.repo;

import java.util.List;

import com.training.tdd.example.model.Product;

public interface IProductRepository {

    public boolean hasProduct(String product);

    public List<Product> getAllProduct();

}