package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DownloadController {

    public DownloadController(PhotoService photoService) {
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        Photo photo;
        photo = photoService.get(id);
        byte[] data = new byte[0];
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
