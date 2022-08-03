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
public class BookInternal {
	@Id 
	@Column(name = "book_id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;
	@Column(name = "title", nullable = false)
    private String title;
	@Column(name = "sub_title")
    private String subTitle;
	@Column(name = "author")
    private String author;
	@Column(name = "series")
    private String series;
	@Column(name = "publisher")
    private String publisher;
	@Column(name = "publish_place")
    private String publishPlace;
	@Column(name = "publish_year")
    private String publishYear;
	@Column(name = "mms_id")
    private String mmsid;
	@Column(name = "is_in_private_collection")
    private int isInPrivateCollection;
	@Column(name = "copied_from_bibliography_internal")
	private int copiedFromBibliographyInternalUsedInDB;
    
	public BookInternal() {}
 
    public BookInternal(Integer id, String title, String subTitle, String author, String series, String publisher, String publishPlace, String publishYear, String mmsid, int isInPrivateCollection) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.series = series;
        this.publisher = publisher;
        this.publishPlace = publishPlace;
        this.publishYear = publishYear;
        this.mmsid = mmsid;
        this.isInPrivateCollection = isInPrivateCollection;
    }
 
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishPlace() {
		return publishPlace;
	}

	public void setPublishPlace(String publishPlace) {
		this.publishPlace = publishPlace;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getMmsid() {
		return mmsid;
	}

	public void setMmsid(String mmsid) {
		this.mmsid = mmsid;
	}

	public int getIsInPrivateCollection() {
		return isInPrivateCollection;
	}

	public void setIsInPrivateCollection(int isInPrivateCollection) {
		this.isInPrivateCollection = isInPrivateCollection;
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
      if (!(o instanceof BookInternal))
        return false;
      BookInternal book = (BookInternal) o;
      return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title)
          && Objects.equals(this.subTitle, book.subTitle) && Objects.equals(this.author, book.author)
          && Objects.equals(this.series, book.series) && Objects.equals(this.publisher, book.publisher)
          && Objects.equals(this.publishPlace, book.publishPlace) && Objects.equals(this.publishYear, book.publishYear)
          && Objects.equals(this.mmsid, book.mmsid) && Objects.equals(this.isInPrivateCollection, book.isInPrivateCollection);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.title, this.subTitle, this.author, this.series, this.publisher, this.publishPlace, this.publishYear, this.mmsid, this.isInPrivateCollection);
    }

    @Override
    public String toString() {
      return "BookInternal{" + "id=" + this.id + ", title='" + this.title + '\'' + ", subTitle='" + this.subTitle + '\'' + 
    		  ", author='" + this.author + '\'' + ", series='" + this.series + '\'' + ", publisher='" + this.publisher +
    		  ", publishPlace='" + this.publishPlace + '\'' + ", publishYear='" + this.publishYear + '\'' + ", mmsid='" + this.mmsid + '\'' +'}';
    }
}


