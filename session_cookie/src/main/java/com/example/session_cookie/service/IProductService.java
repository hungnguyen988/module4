package com.example.session_cookie.service;

import com.example.session_cookie.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(long id);
    Product decreaseQuantity(long id);
}
