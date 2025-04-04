package com.example.JPA_test.repository;

import com.example.JPA_test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student, Integer> {





}
