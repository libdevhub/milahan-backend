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
@JsonIgnoreProperties({"song", "songs"})
//@IdClass(BookSongId.class)
public class SongBooks {
	
//	@Id 
//	@Column(name = "id")
//	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
//	@EmbeddedId
//    public SongBookId id;
	@Id
	public int id;

	@ManyToOne()
	//@JsonBackReference
    //@MapsId("songId")
    @JoinColumn(name = "song_id")
	//@JsonIgnoreProperties({"books"})
	Song songy;
//	@Id
//    Integer songId;

	//@JsonBackReference
    @ManyToOne()
    //@MapsId("bookId")
    @JoinColumn(name = "book_id")
    //@JsonIgnoreProperties({"songs"})
    BookInternal booky;
	
	@Column
    Integer page;
//	@Id
//	Integer bookId;

//    public Integer getSongId() {
//		return songId;
//	}
//
//	public void setSongId(Integer songId) {
//		this.songId = songId;
//	}
//
//	public Integer getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(Integer bookId) {
//		this.bookId = bookId;
//	}
    
//    @ManyToOne
//    @PrimaryKeyJoinColumn(name="song_id", referencedColumnName="song_id")
//    private Song song;
//    
//    @ManyToOne
//    @PrimaryKeyJoinColumn(name="book_id", referencedColumnName="book_id")
//    private Book book;
    
    public SongBooks() {
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!In BooksSongs");
	}

	public SongBooks(Song song, BookInternal book, int page) {
//		super();
		//this.id = new BookInternalSongId(song.getId(), book.getId());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!In BooksSongs");
		//id = new SongBooks.SongBookId();
		//this.id = id;
		this.songy = song;
		this.booky = book;
		this.page = page;
	}

//	public BookSongId getId() {
//		return id;
//	}
//
//	public void setId(BookSongId id) {
//		this.id = id;
//	}

	public Song getSong() {
		return songy;
	}

	public void setSong(Song song) {
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
    
//	@Embeddable
//	public static class SongBookId implements Serializable {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		@Column(name = "song_id")
//	    Integer songId;
//	    
//	    @Column(name = "book_id")
//	    Integer bookId;
//	    
//	    public SongBookId() {
//	    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!In SongBookId");
//			// TODO Auto-generated constructor stub
//		}
//
//	    @Override
//		public int hashCode() {
//			return Objects.hash(bookId, songId);
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			SongBookId other = (SongBookId) obj;
//			return Objects.equals(bookId, other.bookId) && Objects.equals(songId, other.songId);
//		}
//
//		public Integer getSongId() {
//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!In getSongId");
//			return songId;
//		}
//
//		public void setSongId(Integer songId) {
//			this.songId = songId;
//		}
//
//		public SongBookId(Integer songId, Integer bookId) {
//			this.songId = songId;
//			this.bookId = bookId;
//		}
//
//		public Integer getBookId() {
//			return bookId;
//		}
//
//		public void setBookId(Integer bookId) {
//			this.bookId = bookId;
//		}
//	}

}
