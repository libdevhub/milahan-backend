package com.example.milahan;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class BookTitle {
	@Id 
	@Column(name = "book_id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;
	@Column(name = "title", nullable = false)
    private String title;
    
	public BookTitle() {}
 
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
      if (!(o instanceof BookTitle))
        return false;
      BookTitle book = (BookTitle) o;
      return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.title);
    }

    @Override
    public String toString() {
      return "BookTitle {" + "id=" + this.id + ", title='" + this.title  + '\'' +'}';
    }
}


