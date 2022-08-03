package com.example.milahan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class BookTitleController {
 
    @Autowired
    private BookTitleService service;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books_title")
    public ResponseEntity<List<BookTitle>> allTitles() {
    	List<BookTitle> list = service.getAllBooksTitle();

    	return new ResponseEntity<List<BookTitle>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
}
