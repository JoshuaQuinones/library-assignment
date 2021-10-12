//helpful tutorial followed: https://www.youtube.com/watch?v=Koe7oC1Sq0c 
package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARYBOOKS")
public class LibraryBook {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "date")
	private String date;
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public LibraryBook() {}
	
	public LibraryBook(String title, String author, String date) {
		this.title = title;
		this.author = author;
		this.date = date;
	}
	
	//use this to search with id as null
	public LibraryBook(Long id, String title, String author, String date) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
	}
	
	
}
