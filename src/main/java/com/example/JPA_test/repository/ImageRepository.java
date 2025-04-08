package com.example.JPA_test.repository;

import com.example.JPA_test.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageData, Integer> {

}
