package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if(photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
    }

    @PostMapping("/photos")
    public Photo create(@Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }


}
