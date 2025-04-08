package com.example.JPA_test.service;

import com.example.JPA_test.entity.Student;
import com.example.JPA_test.repository.StudentDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("dev")
public class StudentServiceDev implements StudentService {
    private StudentDAO studentDAO;

    public StudentServiceDev(StudentDAO studentDAO) {
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

    public String profile(){
        return "Ovo je dev profil!!";
    }


}
