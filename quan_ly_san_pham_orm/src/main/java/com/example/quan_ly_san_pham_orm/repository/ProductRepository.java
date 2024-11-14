package com.example.quan_ly_san_pham_orm.repository;

import com.example.quan_ly_san_pham_orm.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void update(Product productNew) {
        Product product = findById(productNew.getId());
        if (product!= null) {
            product.setName(productNew.getName());
            product.setPrice(productNew.getPrice());
            product.setDescription(productNew.getDescription());
        }
        entityManager.merge(product);

    }

    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        return result;
    }
}
