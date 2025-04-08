package com.example.JPA_test.service;

import com.example.JPA_test.entity.Student;
import com.example.JPA_test.repository.StudentDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }
    public Optional<Student> findById(int id) {
        return studentDAO.findById(id);
    }

    public Student save(Student student) {
        return studentDAO.save(student);
    }

    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    public List<Student> studentsOlderThan(int minAge) {
        return studentDAO.findStudentsOlderThan(minAge);
    }

    public Integer studentsNamedIvan() {
        return studentDAO.findStudentsNamedIvan();
    }

}
