package com.example.milahan;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

 
@RestController
public class BookController {
 
    @Autowired
    private BookService service;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books")
    public ResponseEntity<Page<Book>> all(
    		 @Or({
  		        @Spec(path = "title", params = "title", spec = Like.class),
  		        @Spec(path = "subTitle", params = "subTitle", spec = Like.class),
  		        @Spec(path = "author", params = "author", spec = Like.class),
  		        @Spec(path = "series", params = "series", spec = Like.class),
  		        @Spec(path = "publisher", params = "publisher", spec = Like.class),
  		        @Spec(path = "publishPlace", params = "publishPlace", spec = Like.class),
  		        @Spec(path = "publishYear", params = "publishYear", spec = Like.class),
  		        @Spec(path = "mmsid", params = "mmsid", spec = Equal.class),
//  		        @Spec(path = "createDate", params = "createDate", spec = Equal.class),
//  		        @Spec(path = "createDate", params = {"createDateGt", "createDateLt"}, spec = Between.class)
     		}) Specification<Book> spec,
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
    	Page<Book> list = service.getAllBooks(pageNo, pageSize, sortBy, spec);

    	return new ResponseEntity<Page<Book>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        try {
        	Book book = service.get(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/books")
    public void add(@RequestBody Book book) {
        service.save(book);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/books/{id}")
    public ResponseEntity<?> update(@RequestBody Book newBook, @PathVariable Integer id) {
        try {
        	Book existBook = service.get(id);
            existBook.setTitle(newBook.getTitle());
            existBook.setSubTitle(newBook.getSubTitle());
            existBook.setAuthor(newBook.getAuthor());
            existBook.setSeries(newBook.getSeries());
            existBook.setPublishPlace(newBook.getPublishPlace());
            existBook.setPublishYear(newBook.getPublishYear());
            existBook.setMmsid(newBook.getMmsid());
            existBook.setIsInPrivateCollection(newBook.getIsInPrivateCollection());
            existBook.setSongs(newBook.getSongs());
            service.save(existBook);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}