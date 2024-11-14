package com.example.test_thymeleaf.repository;

import com.example.test_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1, "Product 1", 100, "Product 1 description"));
        products.add(new Product(2, "Product 2", 200, "Product 2 description"));
        products.add(new Product(3, "Product 3", 300, "Product 3 description"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }


    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void deleteById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public void update(Product productNew) {
        for (Product product : products) {
            if (product.getId() == productNew.getId()) {
                product.setName(productNew.getName());
                product.setPrice(productNew.getPrice());
                product.setDescription(productNew.getDescription());
                break;
            }
        }
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }
}
