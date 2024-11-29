package com.example.new_jwt.repository.category;

import com.example.new_jwt.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {


}
