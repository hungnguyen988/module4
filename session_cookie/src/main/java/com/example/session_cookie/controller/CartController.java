package com.example.session_cookie.controller;

import com.example.session_cookie.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("")
    public String showCart(@ModelAttribute("cart") Cart cart) {
        return "cart/cart";
    }
}
