package com.example.new_jwt.service.category;

import com.example.new_jwt.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(long id);
    void deleteById(long id);
}
