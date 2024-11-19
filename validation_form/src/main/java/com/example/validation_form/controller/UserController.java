package com.example.validation_form.controller;

import com.example.validation_form.dto.UserDTO;
import com.example.validation_form.model.User;
import com.example.validation_form.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showListUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "addUser";
    }

    @PostMapping("/save")
    public String saveUser(@Validated @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
        User user = new User();
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        BeanUtils.copyProperties(userDTO, user);
        userService.addUser(user);
        return "redirect:/";
    }
}
