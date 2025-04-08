package com.example.JPA_test.rest;

import com.example.JPA_test.entity.ImageData;
import com.example.JPA_test.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> storeImage(@RequestParam("file") MultipartFile file) {
         try{
             imageService.storeImage(file);
             return ResponseEntity.ok("Image uploaded succesfully");
         }catch (IOException e){
             return ResponseEntity.status(500).body("Something went wrong");
         }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        if(imageService.getImageById(id).isPresent()){
            ImageData imageData = imageService.getImageById(id).get();
            HttpHeaders headers = new HttpHeaders();
            if(imageData.getName().contains(".png")){
                headers.setContentType(MediaType.IMAGE_PNG);
            }
            if(imageData.getName().contains(".jpg")){
                headers.setContentType(MediaType.IMAGE_JPEG);
            }
            return new ResponseEntity<>(imageData.getData(), headers, HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }




}
