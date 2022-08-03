package com.example.milahan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class BookTitleService {
 
    @Autowired
    private BookTitleRepository repository;
     
    public List<BookTitle> getAllBooksTitle() {
    	return repository.findAll();
    }
}