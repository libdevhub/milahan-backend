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
@Table(name = "subjects")
public class Subject {
	@Id 
	@Column(name="subject_id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;
	@Column(name="name", nullable = false)
    private String name;

	public Subject() {}
 
    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
      if (!(o instanceof Subject))
        return false;
      Subject subject = (Subject) o;
      return Objects.equals(this.id, subject.id) && Objects.equals(this.name, subject.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
      return "Song{" + "id=" + this.id + ", name='" + this.name + '\'' +'}';
    }
}

