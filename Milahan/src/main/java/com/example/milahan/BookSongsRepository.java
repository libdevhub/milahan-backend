package com.example.milahan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSongsRepository  extends JpaRepository<BookSongs, BookSongIdTemp> {

}
