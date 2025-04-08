package com.example.JPA_test.service;

import com.example.JPA_test.entity.ImageData;
import com.example.JPA_test.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageData storeImage(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        byte[] filedata = file.getBytes();

        ImageData image = new ImageData(filename, filedata);
        return imageRepository.save(image);
    }

    public Optional<ImageData> getImageById(Integer id) {
        return imageRepository.findById(id);

    }
}
