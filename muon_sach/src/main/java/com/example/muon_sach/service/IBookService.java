package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> listAllBooks();
    String borrowBook(Long bookId) throws Exception;
    void returnBook(String code) throws Exception;
    Book getBookById(Long id);
}
