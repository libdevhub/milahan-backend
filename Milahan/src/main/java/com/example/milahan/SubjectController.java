package com.example.milahan;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

 
@RestController
public class SubjectController {
 
    @Autowired
    private SubjectService service;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/subjects")
    public ResponseEntity<Page<Subject>> all(
    		@Or({
 		        @Spec(path = "name", params = "subjects", spec = Like.class)
    		}) Specification<Subject> spec,
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
    	Page<Subject> list = service.getAllSubjects(pageNo, pageSize, sortBy, spec);

    	return new ResponseEntity<Page<Subject>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> get(@PathVariable Integer id) {
        try {
        	Subject subject = service.get(id);
            return new ResponseEntity<Subject>(subject, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/subjects")
    public void add(@RequestBody Subject subject) {
        service.save(subject);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/subjects/{id}")
    public ResponseEntity<?> update(@RequestBody Subject newSubject, @PathVariable Integer id) {
        try {
        	Subject existSubject = service.get(id);
            existSubject.setName(newSubject.getName());
            service.save(existSubject);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/subjects/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}