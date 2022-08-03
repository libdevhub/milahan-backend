package com.example.milahan;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repository;
     
    public List<User> listAll() {
        return repository.findAll();
    }
     
    public void save(User user) {
        repository.save(user);
    }
     
    public User get(Integer id) {
        return repository.findById(id).get();
    }
     
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}