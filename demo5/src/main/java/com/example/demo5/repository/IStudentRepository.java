package com.example.demo5.repository;

import com.example.demo5.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAllStudents();
    Student findById(int id);
    void save(Student student);
    void deleteById(int id);
}
