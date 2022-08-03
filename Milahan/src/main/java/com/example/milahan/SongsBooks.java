package com.example.milahan;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "books_songs")
@Data
//@IdClass(BookSongId.class)
public class SongsBooks {
	
	@Id
	public int id;

	@ManyToOne()
    @JoinColumn(name = "song_id")
	SongInternal songy;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    BookInternal booky;
	
	@Column
    Integer page;
    
    public SongsBooks() {}

	public SongsBooks(SongInternal song, BookInternal book, int page) {
		this.songy = song;
		this.booky = book;
		this.page = page;
	}

	public SongInternal getSong() {
		return songy;
	}

	public void setSong(SongInternal song) {
		this.songy = song;
	}

	public BookInternal getBook() {
		return booky;
	}

	public void setBook(BookInternal book) {
		this.booky = book;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
