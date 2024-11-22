package com.example.session_cookie.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> product) {
        this.products = product;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }


    public void addCart(Product product) {
        if (products.containsKey(product)) {
            Integer currentQuantity = products.get(product);
            products.put(product, currentQuantity + 1);
        } else {
            products.put(product, 1);
        }

    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }


}
