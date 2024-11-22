package com.example.demo.controller.blog;

import com.example.demo.dto.BlogDTO;
import com.example.demo.model.Blog;
import com.example.demo.service.blog.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAllBlogs(Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveBlog(@RequestBody BlogDTO blogDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blogService.save(blog);
        return new ResponseEntity<>("add success",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long id) {

        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            blogService.deleteById(id);
            return new ResponseEntity<>("delete success", HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Long id, @RequestBody BlogDTO blogDTO) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (blogDTO.getTitle()!= null) {
                blog.setTitle(blogDTO.getTitle());
            }
            if (blogDTO.getContent()!= null) {
                blog.setContent(blogDTO.getContent());
            }
            if (blogDTO.getCategory()!= null) {
                blog.setCategory(blogDTO.getCategory());
            }
            return new ResponseEntity<>("update success", HttpStatus.OK);
        }
    }

}
