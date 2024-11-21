package com.example.muon_sach.controller;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String listAllBooks(Model model) {
        List<Book> books = bookService.listAllBooks();
        model.addAttribute("books", books);
        return "list";
    }


    @GetMapping("/borrow")
    public String borrowBookPage(@RequestParam Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "borrow";
    }


    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long id, Model model) {
        try {
            String borrowCode = bookService.borrowBook(id);
            model.addAttribute("message", "Borrow successful! Code: " + borrowCode);
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        return "result";
    }

    @GetMapping("/return")
    public String returnBookPage() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, Model model) {
        try {
            bookService.returnBook(code);
            model.addAttribute("message", "Return successful!");
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        return "result";
    }
}
