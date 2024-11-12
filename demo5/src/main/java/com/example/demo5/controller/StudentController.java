package com.example.demo5.controller;

import com.example.demo5.model.Student;
import com.example.demo5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebServlet;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;



    @RequestMapping ("/")
    public String student(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student";
    }

    @GetMapping("/student/add")
    public String addStudent() {
        return "addStudent";
    }

    @PostMapping("/saveStudent")
    public String addStudent(@RequestParam int id,@RequestParam String name,Model model) {
        studentService.save(new Student(id, name));
        model.addAttribute("students", studentService.getAllStudents());
        return "student";
    }

}
