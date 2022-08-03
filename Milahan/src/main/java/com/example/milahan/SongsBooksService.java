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
public class SongsBooksService {
 
    @Autowired
    private SongsBooksRepository repository;
     
    public void save(SongsBooks sb) {
        repository.save(sb);
    }
//     
//    public Song get(Integer id) {
//        return repository.findById(id).get();
//    }
     
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
