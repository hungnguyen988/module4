package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
    }

    @Override
    public List<Blog> searchByTitle(String title) {
//        return blogRepository.searchByTitleContaining(title);
        return blogRepository.searchByName("%" + title + "%");
    }
}
