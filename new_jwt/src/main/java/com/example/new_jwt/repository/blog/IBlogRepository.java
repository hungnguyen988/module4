package com.example.new_jwt.repository.blog;

import com.example.new_jwt.model.Blog;
import com.example.new_jwt.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    //    List<Blog> searchByTitleContaining(String title);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);

    @Query(value = "select * from blog where blog.title like :title", nativeQuery = true)
    List<Blog> searchByName(@Param("title") String title);

}
