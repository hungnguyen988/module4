package com.example.test_thymeleaf.controller;

import com.example.test_thymeleaf.model.Product;
import com.example.test_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String adminPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Product added successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("successMessage", "Product updated successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully!");
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products", products);
        return "list";
    }

}
