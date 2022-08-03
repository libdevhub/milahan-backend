package com.example.milahan;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

interface SongRepository extends PagingAndSortingRepository<Song, Integer>, JpaSpecificationExecutor<Song>  {
	
}
