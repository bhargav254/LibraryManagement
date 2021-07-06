package com.slk.librarymanagement.service;

import java.util.List;

import com.slk.librarymanagement.model.Book;

public interface BookService {

	Book addBook(Book book);
	
	List<Book> getBooks();
	
	Book updateBook(Book book);
	
	boolean removeBook(Book book);
	
	Book getBookByBookId(int bookId);
}
