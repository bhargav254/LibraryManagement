package com.slk.librarymanagement.dao;

import java.util.List;

import com.slk.librarymanagement.model.Book;

public interface BookDao {

	Book addBook(Book book);
	
	List<Book> getBooks();
	
	Book updateBook(Book book);
	
	boolean removeBook(Book book);
}
