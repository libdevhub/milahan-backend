package com.example.milahan;

import lombok.AllArgsConstructor;  
import lombok.Data;  
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
class BookSongIdTemp implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "song_id")
    Integer songId;
    
    @Column(name = "book_id")
    Integer bookId;
    
    public BookSongIdTemp() {
		// TODO Auto-generated constructor stub
	}

    @Override
	public int hashCode() {
		return Objects.hash(bookId, songId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookSongIdTemp other = (BookSongIdTemp) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(songId, other.songId);
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public BookSongIdTemp(Integer songId, Integer bookId) {
		this.songId = songId;
		this.bookId = bookId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
