package com.example.JPA_test.rest;

import com.example.JPA_test.entity.Student;
import com.example.JPA_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/getall")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studentService.deleteById(id);
    }
}
