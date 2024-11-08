package com.example.tu_dien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionnaryController {

    private Map<String, String> dictionary = new HashMap<>();
    {
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("goodbye", "tạm biệt");
        dictionary.put("thank", "cảm ơn");
    }

    @RequestMapping("/")
    public String dictionary() {
        return "dictionary";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String word , Model model) {
        String translation = dictionary.get(word.toLowerCase());
        if (translation == null) {
            model.addAttribute("message", "Từ không tìm thấy trong từ điển");
        } else {
            model.addAttribute("word", word);
            model.addAttribute("meaning", translation);
        }
        return "translate";
    }

}
