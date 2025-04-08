package com.example.JPA_test.repository;

import com.example.JPA_test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.age > :minAge")
    List<Student> findStudentsOlderThan(@Param("minAge") int minAge);

    @Query(value = "SELECT COUNT(*) FROM student where email LIKE 'ivan%' ", nativeQuery = true)
    Integer findStudentsNamedIvan();


}
