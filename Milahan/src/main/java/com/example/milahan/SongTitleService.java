package com.example.milahan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class SongTitleService {
 
    @Autowired
    private SongTitleRepository repository;
     
    public List<SongTitle> getAllSongsTitle() {
    	return repository.findAll();
    }
}