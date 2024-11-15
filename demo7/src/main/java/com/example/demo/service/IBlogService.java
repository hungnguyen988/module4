package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(long id);
    void save(Blog blog);
    void deleteById(long id);
    void update(Blog blog);
    List<Blog> searchByTitle(String title);
}
