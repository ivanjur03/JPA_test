package com.example.JPA_test.rest;

import com.example.JPA_test.entity.Student;
import com.example.JPA_test.service.StudentService;
import com.example.JPA_test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    private TestService testService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/test-ssl")
    public String testSSLConnection() {
        return testService.makeSecureRequest();
    }

    @GetMapping("/profile")
    public String profile() {
        return studentService.profile();
    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/student/all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/student/{age}")
    public List<Student> findStudentsOld(@PathVariable int age) {
        return studentService.studentsOlderThan(age);
    }

    @GetMapping("/student/ivan")
    public Integer findStudentsIvan() {
        return studentService.studentsNamedIvan();
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studentService.deleteById(id);
    }
}
