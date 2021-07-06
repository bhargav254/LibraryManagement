package com.slk.librarymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.librarymanagement.model.Book;
import com.slk.librarymanagement.repository.BookRepository;
import com.slk.librarymanagement.service.BookService;

/**
 * @author bhargav
 * Service class for book
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Book addBook(final Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book updateBook(final Book book) {
		
		bookRepo.save(book);
		return null;
	}

	@Override
	public boolean removeBook(final Book book) {
		
		bookRepo.delete(book);
		return true;
	}

	@Override
	public Book getBookByBookId(final int bookId) {
		
		return bookRepo.findBookByBookId(bookId);
	}

}
