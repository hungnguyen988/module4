package com.example.test_thymeleaf.service;

import com.example.test_thymeleaf.model.Product;
import com.example.test_thymeleaf.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
