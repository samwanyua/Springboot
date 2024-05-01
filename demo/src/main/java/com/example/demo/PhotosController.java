package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PhotosController {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hello(){
        return "Hello Sam, you are using SpringBoot!";
    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if(photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
        return photo;
    }
}
