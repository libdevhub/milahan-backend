package com.example.milahan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class SongsBooksController {
 
    @Autowired
    private SongsBooksService service;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/songbook")
    public void add(@RequestBody SongsBooks songBook) {
        service.save(songBook);
    }
//    
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PutMapping("/songbooks/{id}")
//    public ResponseEntity<?> update(@RequestBody Song newSong, @PathVariable Integer id) {
//        try {
//        	Song existSong = service.get(id);
//            existSong.setTitle(newSong.getTitle());
//            existSong.setLyrics(newSong.getLyrics());
//            existSong.setComposer(newSong.getComposer());
//            existSong.setFirstWords(newSong.getFirstWords());
//            existSong.setSubjects(newSong.getSubjects());
//            existSong.setBooks(newSong.getBooks());
//            //existSong.setBooks(newSong.getBooks());
//            service.save(existSong);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }      
//    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/songbook/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}