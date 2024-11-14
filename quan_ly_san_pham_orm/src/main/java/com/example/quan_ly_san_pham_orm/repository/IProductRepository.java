package com.example.quan_ly_san_pham_orm.repository;

import com.example.quan_ly_san_pham_orm.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void deleteById(int id);
    void update(Product product);
    List<Product> searchByName(String name);
}
