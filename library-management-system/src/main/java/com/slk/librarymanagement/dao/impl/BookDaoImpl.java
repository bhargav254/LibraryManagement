package com.slk.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.slk.librarymanagement.dao.BookDao;
import com.slk.librarymanagement.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Book addBook(Book book) {
		
		entityManager.persist(book);
		return book;
	}

	@Override
	public List<Book> getBooks() {
		
		List<Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
		return books;
	}

	@Override
	public Book updateBook(Book book) {
		
		return entityManager.merge(book);
	}

	@Override
	public boolean removeBook(Book book) {
		
		entityManager.remove(book);
		return true;
	}

}
