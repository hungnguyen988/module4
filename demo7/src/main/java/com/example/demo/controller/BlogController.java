package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String getAllBlogs(Model model) {
        model.addAttribute("blogs",  blogService.findAll());;
        return "list";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam long id, RedirectAttributes redirectAttributes) {
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Deleted blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String editBlog(@RequestParam long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "save";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Saved blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "save";
    }

    @PostMapping("/search")
    public String searchBlog(@RequestParam("search") String title , Model model) {
        model.addAttribute("blogs", blogService.searchByTitle(title));
        return "list";
    }
}
