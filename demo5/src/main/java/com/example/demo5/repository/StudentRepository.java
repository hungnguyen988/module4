package com.example.demo5.repository;

import com.example.demo5.model.Student;

import java.util.List;

public class StudentRepository implements IStudentRepository  {
    @Override
    public List<Student> getAllStudents() {
        return List.of();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void deleteById(int id) {

    }
}
