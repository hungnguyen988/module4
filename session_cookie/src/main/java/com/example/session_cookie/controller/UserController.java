package com.example.session_cookie.controller;

import com.example.session_cookie.model.User;
import com.example.session_cookie.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "/user/register";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model,
                            HttpServletResponse response) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(usernameCookie);
            return "redirect:/product";
        } else  {
            model.addAttribute("error", "Invalid username or password");
            return "/user/register";
        }
    }
}