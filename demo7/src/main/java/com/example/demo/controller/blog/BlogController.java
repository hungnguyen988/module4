package com.example.demo.controller.blog;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.blog.BlogService;
import com.example.demo.service.category.ICategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam long id, RedirectAttributes redirectAttributes) {
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Deleted blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String editBlog(@RequestParam long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/save";
    }

    @PostMapping("/save")
    public String saveBlog(@RequestParam long categoryId, Blog blog, RedirectAttributes redirectAttributes) {
        blog.setCategory(categoryService.findById(categoryId));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Saved blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/save";
    }

    @GetMapping("")
    public String getAllBlogs(@RequestParam(required = false, defaultValue = "0") int page,
                              @RequestParam(required = false, defaultValue = "") String searchTitle,
                              Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt").and(Sort.by(Sort.Direction.DESC, "title"));
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> blogs = blogService.findAllWithTitleFilter( searchTitle,  pageable);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blogs", blogs);
        model.addAttribute("searchTitle", searchTitle);
        return "blog/list";

    }

    @GetMapping("/searchByCategory")
    public String searchBlog(@RequestParam Long categoryId,
                             @RequestParam(required = false, defaultValue = "0") int page,
                             Model model) {
        Pageable pageable = PageRequest.of(page, 2);

        Category category = categoryService.findById(categoryId);

        Page<Blog> blogs = blogService.findAllByCategory(category, pageable);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/userInfo")
    public String userInfo(HttpServletRequest request, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

//        User loginedUser = (User) ((Authentication) principal).getPrincipal();

//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        System.out.println("-----------------detail----------");
//        System.out.println(userInfo);
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "userInfoPage";
        } else if (request.isUserInRole("ROLE_USER")) {
            return "userHome";
        }else {
            return "error";
        }
    }

//    @GetMapping("/logout")
//    public String logout(){
//        return "logout";
//    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
