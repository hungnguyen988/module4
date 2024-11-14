package com.example.test_thymeleaf.service;

import com.example.test_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void deleteById(int id);
    void update(Product product);
    List<Product> searchByName(String name);
}
