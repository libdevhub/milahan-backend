package com.example.milahan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "songs")
public class SongInternal {
	@Id 
	@Column(name="song_id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;
	@Column(name="title", nullable = false)
    private String title;
	@Column(name="lyrics")
    private String lyrics;
	@Column(name="composer")
    private String composer;
	@Column(name="first_words")
    private String firstWords;
//	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinTable(name = "books_songs",
//     joinColumns = @JoinColumn(name = "song_id"),
//     inverseJoinColumns = @JoinColumn(name = "book_id"))
	//@JsonManagedReference
//	@JsonIgnoreProperties("Book[songs]")//("Book[\"songs\"]")
	//@JsonIgnoreProperties("songy")
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "songy")
	@ManyToMany
	@JoinTable(
			  name = "subjects_songs", 
			  joinColumns = @JoinColumn(name = "song_id"), 
			  inverseJoinColumns = @JoinColumn(name = "subject_id"))
	List<Subject> subjects = new ArrayList<Subject>();

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = new ArrayList<Subject>();
		for (int i=0; i<subjects.size(); i++) {
        	this.subjects.add(subjects.get(i));
        }
	}

	public SongInternal() {}
 
    public SongInternal(Integer id, String title, String lyrics, String composer, String firstWords, Subject[] subjects, SongBooks[] books) {
        this.id = id;
        this.title = title;
        this.lyrics = lyrics;
        this.composer = composer;
        this.firstWords = firstWords;
        for (int i=0; i<subjects.length; i++) {
        	this.subjects.add(subjects[i]);
        }
    }
 
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getFirstWords() {
		return firstWords;
	}

	public void setFirstWords(String firstWords) {
		this.firstWords = firstWords;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getId() {
        return this.id;
    }

	@Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof SongInternal))
        return false;
      SongInternal song = (SongInternal) o;
      return Objects.equals(this.id, song.id) && Objects.equals(this.title, song.title)
          && Objects.equals(this.lyrics, song.lyrics) && Objects.equals(this.composer, song.composer) && Objects.equals(this.firstWords, song.firstWords);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.title, this.lyrics, this.composer, this.firstWords);
    }

    @Override
    public String toString() {
      return "Song{" + "id=" + this.id + ", title='" + this.title + '\'' + ", lyrics='" + this.lyrics + '\'' + ", composer='" + this.composer + '\'' + ", firstWords='" + this.firstWords + '\'' +'}';
    }
}

