package com.slk.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.librarymanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	Book findBookByIsbn(String isbn);
	
	Book findBookByBookId(int bookId);
	
	@Query("select b from Book b where b.isbn = :isbn and b.publisher = :pub")
	Book findBook(String isbn, String pub);
}
