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
public class SongTitle {
	@Id 
	@Column(name="song_id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;
	@Column(name="title", nullable = false)
    private String title;
	
	public SongTitle() {}
 
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
      if (!(o instanceof SongTitle))
        return false;
      SongTitle song = (SongTitle) o;
      return Objects.equals(this.id, song.id) && Objects.equals(this.title, song.title);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.title);
    }

    @Override
    public String toString() {
      return "Song{" + "id=" + this.id + ", title='" + this.title + '\'' +'}';
    }
}


