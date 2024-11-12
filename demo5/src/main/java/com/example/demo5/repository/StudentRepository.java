package com.example.demo5.repository;

import com.example.demo5.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private List<Student> students = new ArrayList<>();

    {
        students.add(new Student(1, "John Doe1"));
        students.add(new Student(2, "John Doe2"));
        students.add(new Student(3, "John Doe3"));
        students.add(new Student(4, "John Doe4"));
        students.add(new Student(5, "John Doe5"));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void deleteById(int id) {

    }
}
