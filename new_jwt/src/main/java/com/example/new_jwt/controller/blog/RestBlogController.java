package com.example.new_jwt.controller.blog;

import com.example.new_jwt.config.JwtUtils;
import com.example.new_jwt.dto.BlogDTO;
import com.example.new_jwt.model.AppUser;
import com.example.new_jwt.model.Blog;
import com.example.new_jwt.repository.AppUserRepository;
import com.example.new_jwt.service.blog.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("")
    public ResponseEntity<?> getBlogs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        int defaultPage = 0;
        int defaultSize = 5;

        int currentPage = (page != null) ? page : defaultPage;
        int currentSize = (size != null) ? size : defaultSize;

        Pageable pageable = PageRequest.of(currentPage, currentSize);
        Page<Blog> blogPage;

        blogPage = blogService.findAllWithTitleFilter(title, pageable);

        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("content", blogPage.getContent());
        response.put("currentPage", blogPage.getNumber());
        response.put("totalItems", blogPage.getTotalElements());
        response.put("totalPages", blogPage.getTotalPages());
        response.put("size", blogPage.getSize());
        response.put("first", blogPage.isFirst());
        response.put("last", blogPage.isLast());
        response.put("sort", blogPage.getSort());


        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> saveBlog(@RequestBody BlogDTO blogDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blogService.save(blog);
        return new ResponseEntity<>("add success", HttpStatus.CREATED);
    }

    @GetMapping("/searchById/{id}")
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
        } else {
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
            if (blogDTO.getTitle() != null) {
                blog.setTitle(blogDTO.getTitle());
            }
            if (blogDTO.getContent() != null) {
                blog.setContent(blogDTO.getContent());
            }
            if (blogDTO.getCategory() != null) {
                blog.setCategory(blogDTO.getCategory());
            }
            return new ResponseEntity<>("update success", HttpStatus.OK);
        }
    }

    // sử dụng jwt
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AppUser user) {
        AppUser userDb = appUserRepository.findByUserName(user.getUserName());

        if (userDb.getUserName() != null && userDb.getEncrytedPassword().equals(user.getEncrytedPassword())) {
            String token = jwtUtils.generateToken(user.getUserName());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("token", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/profile")
    public ResponseEntity<String> getUserProfile() {
        // Lấy thông tin Authentication từ SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Lấy username từ Authentication (đã được bộ lọc JwtAuthFilter xử lý)
        String username = authentication.getName();

        return new ResponseEntity<>(username, HttpStatus.OK);
    }

}