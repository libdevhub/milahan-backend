package com.example.milahan;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

 
@RestController
public class UserController {
 
    @Autowired
    private UserService service;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    List<User> all() {
      return service.listAll();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
        	User user = service.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @PostMapping("/users")
    public void add(@RequestBody User user) {
        service.save(user);
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@RequestBody User newUser, @PathVariable Integer id) {
        try {
        	User existUser = service.get(id);
            existUser.setName(newUser.getName());
            existUser.setEmail(newUser.getEmail());
            existUser.setRole(newUser.getRole());
            existUser.setPassword(newUser.getPassword());
            service.save(existUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}