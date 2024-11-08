package com.example.demo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.WebServlet;

@Controller
public class StudentController {
    @RequestMapping ("/student")
    public String student() {
        return "student";
    }

}
