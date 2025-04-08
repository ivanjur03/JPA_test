package com.example.JPA_test.service;

import com.example.JPA_test.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(int id);
    Student save(Student student);
    void deleteById(int id);
    List<Student> studentsOlderThan(int minAge);
    Integer studentsNamedIvan();
    String profile();
}

