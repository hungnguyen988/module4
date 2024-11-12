package com.example.hom_thu;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {
    private Setting currentSetting = new Setting();
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("setting", currentSetting);
        return "home";
    }

    @PostMapping("/update")
    public String updateSetting(@ModelAttribute("setting") Setting setting, RedirectAttributes redirectAttributes) {
        this.currentSetting = setting;
        if (currentSetting!= null){
            redirectAttributes.addFlashAttribute("message", "Setting updated successfully!");
        }
        return "redirect:/";

    }
}
