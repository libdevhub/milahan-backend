package com.example.milahan;

import org.springframework.data.jpa.repository.JpaRepository;


interface UserRepository extends JpaRepository<User, Integer> {

}

