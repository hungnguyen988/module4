package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BorrowRecord;
import com.example.muon_sach.repository.BookRepository;
import com.example.muon_sach.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService implements IBookService {
    @Autowired
    private  BookRepository bookRepository;
    @Autowired
    private  BorrowRecordRepository borrowRecordRepository;


    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public String borrowBook(Long bookId) throws Exception {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isEmpty() || bookOpt.get().getQuantity() <= 0) {
            throw new Exception("Book not available!");
        }

        Book book = bookOpt.get();
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String borrowCode = generateBorrowCode();
        BorrowRecord record = new BorrowRecord();
        record.setBorrowCode(borrowCode);
        record.setBookId(bookId);
        borrowRecordRepository.save(record);

        return borrowCode;
    }

    public void returnBook(String code) throws Exception {
        Optional<BorrowRecord> recordOpt = borrowRecordRepository.findById(code);
        if (recordOpt.isEmpty()) {
            throw new Exception("Invalid borrow code!");
        }

        BorrowRecord record = recordOpt.get();
        Book book = bookRepository.findById(record.getBookId()).orElseThrow(() -> new Exception("Book not found!"));
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        borrowRecordRepository.delete(record);
    }

    private String generateBorrowCode() {
        return String.format("%05d", new Random().nextInt(100000));
    }
}
