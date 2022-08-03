package com.example.milahan;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


interface BookRepository extends PagingAndSortingRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

}
