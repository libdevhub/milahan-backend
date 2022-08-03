package com.example.milahan;

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
public class SubjectService {
 
    @Autowired
    private SubjectRepository repository;
     
    public Page<Subject> getAllSubjects(Integer pageNo, Integer pageSize, String sortBy, Specification<Subject> spec) {
    	Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    	 
        Page<Subject> pagedResult = repository.findAll(spec, paging);
        
        return pagedResult;
    }
     
    public void save(Subject subject) {
        repository.save(subject);
    }
     
    public Subject get(Integer id) {
        return repository.findById(id).get();
    }
     
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
