package com.example.milahan;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class SongService {
 
    @Autowired
    private SongRepository repository;
    
    public Page<Song> getAllSongs(Integer pageNo, Integer pageSize, String sortBy, Specification<Song> spec)
    {
    	Pageable paging;
    	if(pageSize != 5000) {
    		paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    	}
    	else {
    		paging = Pageable.unpaged();
    	}
 
        Page<Song> pagedResult = repository.findAll(spec, paging);
        
        return pagedResult;
         
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<Song>();
//        }
    }
     
//    public List<Song> listAll() {
//        return repository.findAll();
//    }
     
    public void save(Song song) {
        repository.save(song);
    }
     
    public Song get(Integer id) {
        return repository.findById(id).get();
    }
     
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
