package com.example.gia_vi;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiments, Model model){
        model.addAttribute("condiments", condiments);
        return "result";
    }

}
