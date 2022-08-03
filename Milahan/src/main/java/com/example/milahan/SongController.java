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

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

 
@RestController
public class SongController {
 
    @Autowired
    private SongService service;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/songs")
    public ResponseEntity<Page<Song>> getAllSongs(
    		@Join(path= "subjects", alias = "s") // alias specified for joined path
    		 @Or({
 		        @Spec(path = "title", params = "title", spec = Like.class),
 		        @Spec(path = "lyrics", params = "lyrics", spec = Like.class),
 		        @Spec(path = "composer", params = "composer", spec = Like.class),
 		        @Spec(path = "firstWords", params = "firstWords", spec = Like.class),
 		        //@Spec(path = "subjects.name", params = "subjects", spec = Equal.class),
 		        @Spec(path="s.name", params="subjects", spec=Equal.class)
// 		        @Spec(path = "createDate", params = "createDate", spec = Equal.class),
// 		        @Spec(path = "createDate", params = {"createDateGt", "createDateLt"}, spec = Between.class)
    		}) Specification<Song> spec,
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
    	Page<Song> list = service.getAllSongs(pageNo, pageSize, sortBy, spec);

    	return new ResponseEntity<Page<Song>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
//    List<Song> all() {
//      return service.listAll();
//    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> get(@PathVariable Integer id) {
        try {
        	Song song = service.get(id);
            return new ResponseEntity<Song>(song, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/songs")
    public void add(@RequestBody Song song) {
        service.save(song);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/songs/{id}")
    public ResponseEntity<?> update(@RequestBody Song newSong, @PathVariable Integer id) {
        try {
        	Song existSong = service.get(id);
            existSong.setTitle(newSong.getTitle());
            existSong.setLyrics(newSong.getLyrics());
            existSong.setComposer(newSong.getComposer());
            existSong.setFirstWords(newSong.getFirstWords());
            existSong.setSubjects(newSong.getSubjects());
            existSong.setBooks(newSong.getBooks());
            //existSong.setBooks(newSong.getBooks());
            service.save(existSong);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/songs/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}