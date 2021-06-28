package com.slk.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.librarymanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	Book findBookByIsbn(String isbn);
	
	Book findBookByBookId(int bookId);
}
