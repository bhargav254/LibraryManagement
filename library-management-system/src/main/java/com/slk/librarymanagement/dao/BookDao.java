package com.slk.librarymanagement.dao;

import java.util.List;

import com.slk.librarymanagement.model.Book;

public interface BookDao {

	public Book addBook(Book book);
	
	public List<Book> getBooks();
	
	public Book updateBook(Book book);
	
	public boolean removeBook(Book book);
}
