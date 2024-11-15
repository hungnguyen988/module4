package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    List<Blog> searchByTitleContaining(String title);

    @Query(value = "select * from blog where blog.title like :title", nativeQuery = true)
    List<Blog> searchByName(@Param("title") String title);

}
