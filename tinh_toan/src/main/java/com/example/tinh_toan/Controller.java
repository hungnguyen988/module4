package com.example.tinh_toan;

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

    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1,@RequestParam double num2,@RequestParam("operation") String operator, Model model) {
        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    model.addAttribute("message", "Chia cho 0 không hợp lệ");
                }
                result = num1 / num2;
                break;
            default:
                model.addAttribute("message", "Toán tử không hợp lệ");
                return "home";
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        return "result";
    }
}
