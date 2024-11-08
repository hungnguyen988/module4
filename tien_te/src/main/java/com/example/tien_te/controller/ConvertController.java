package com.example.tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @RequestMapping("/")
    public String home() {
        return "form";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam double rate, @RequestParam double usd, Model model) {
        double vnd = usd * rate;
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", vnd);
        return "result";
    }

}
