package com.slk.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.librarymanagement.dao.BookDao;
import com.slk.librarymanagement.model.Book;
import com.slk.librarymanagement.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookDao bookDao;
	
	@PostMapping("/book")
	//@ApiOperation(value = "Add a book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		bookRepo.save(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@GetMapping("/books")
	//@ApiOperation(value = "Get all books")
	public ResponseEntity<List<Book>> getAllBooks() {
		
		//List<Book> books = bookRepo.findAll();
		
		List<Book> books = bookDao.getBooks();
		
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
	
	//@DeleteMapping(value = "/books/{isbn}")
	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn) {
		
		Book existingBook = bookRepo.findBookByIsbn(isbn);
		if(existingBook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
		{
			bookRepo.delete(existingBook);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	//@GetMapping(value = "/books/{isbn}")
	//public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") String isbn) {
	
	@RequestMapping(value = "/books/{book_id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBookByBookId(@PathVariable("book_id") int id) {
		
		//Book book = bookRepo.findBookByIsbn(isbn);
		Book book = bookRepo.findBookByBookId(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
}
