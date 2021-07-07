package com.slk.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.librarymanagement.model.Book;
import com.slk.librarymanagement.repository.BookRepository;
import com.slk.librarymanagement.service.BookService;

import io.swagger.annotations.ApiOperation;

/**
 * @author bhargav
 * This is a controller class
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookService bookService;
	
	/**
	 * @param book
	 * @return
	 */
	@PostMapping("/book")
	@ApiOperation(value = "Add a book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		final Book savedBook = bookService.addBook(book);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}
	
	
	/**
	 * @return
	 */
	@GetMapping("/books")
	@ApiOperation(value = "Get all books")
	public ResponseEntity<List<Book>> getAllBooks() {
		
		final List<Book> bookList = bookService.getBooks();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}
	
	
	/**
	 * @param isbn
	 * @param book
	 * @return
	 */
	@PutMapping("/books/{isbn}")
	@ApiOperation(value = "Update a book")
	public ResponseEntity<Book> updateBook(@PathVariable("isbn") String isbn, @RequestBody Book book) {
		
		final Book existingBook = bookRepo.findBookByIsbn(isbn);
		Book updatedBook;
		
		if(existingBook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
		{
			updatedBook = bookService.updateBook(book);
			return new ResponseEntity<>(updatedBook, HttpStatus.OK);
		}
	}
	
	
	/**
	 * @param isbn
	 * @return
	 */
	@DeleteMapping(value = "/books/{isbn}")
	@ApiOperation(value = "Delete a book")
	public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn) {
		
		final Book existingBook = bookRepo.findBookByIsbn(isbn);
		if(existingBook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
		{
			bookService.removeBook(existingBook);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/books/{isbn}")
	@ApiOperation(value = "Get a book by book id")
	public ResponseEntity<Book> getBookByBookId(@PathVariable("book_id") int id) {
		
		Book book = bookRepo.findBookByBookId(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	
	/**
	 * @param isbn
	 * @param publisher
	 * @return
	 */
	@GetMapping(value = "/books/{isbn}/{publisher}")
	@ApiOperation(value = "Find book by isbn and publisher")
	public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn, @PathVariable("publisher") String publisher) {

		final Book book = bookRepo.findBook(isbn, publisher);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
}
