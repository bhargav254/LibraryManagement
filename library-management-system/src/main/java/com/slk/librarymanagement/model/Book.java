package com.slk.librarymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int bookId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false, unique = true)
	private String isbn;
	
	private String author;
	
	private String publisher;
	
	public Book() {
		// Default constructor
	}

	public Book(int bookId, String title, String isbn, String author, String publisher) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", author=" + author + ", publisher="
				+ publisher + "]";
	}
	
}
