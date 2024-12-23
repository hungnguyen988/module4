package com.example.new_jwt.service.category;

import com.example.new_jwt.model.Category;
import com.example.new_jwt.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }


}
