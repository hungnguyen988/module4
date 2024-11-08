package com.example.demo5.service;

import com.example.demo5.model.Student;

import java.util.List;

public class StudentService implements IStudentService  {
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
