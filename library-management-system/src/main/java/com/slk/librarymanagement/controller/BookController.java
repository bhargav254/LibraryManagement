package com.slk.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.librarymanagement.model.Book;
import com.slk.librarymanagement.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/book")
	//@ApiOperation(value = "Add a book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		bookRepo.save(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@GetMapping("/books")
	//@ApiOperation(value = "Get all books")
	public ResponseEntity<List<Book>> getAllBooks() {
		
		List<Book> books = bookRepo.findAll();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@PutMapping("/books/{isbn}")
	//@ApiOperation(value = "Update a book")
	public ResponseEntity<Book> updateBook(@PathVariable("isbn") String isbn, @RequestBody Book book) {
		
		Book existingBook = bookRepo.findBookByIsbn(isbn);
		if(existingBook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
		{
			bookRepo.save(book);
			return new ResponseEntity<>(book, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn, @RequestBody Book book) {
		
		Book existingBook = bookRepo.findBookByIsbn(isbn);
		if(existingBook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
		{
			bookRepo.delete(existingBook);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
