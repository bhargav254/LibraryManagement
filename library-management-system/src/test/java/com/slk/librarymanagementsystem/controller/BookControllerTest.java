package com.slk.librarymanagementsystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slk.librarymanagement.controller.BookController;
import com.slk.librarymanagement.model.Book;
import com.slk.librarymanagement.service.BookService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testgetAllBooks() throws Exception {
		
		Book book1 = new Book(1, "title1", "isbn1", "author1", "publisher1");
		Book book2 = new Book(2, "title2", "isbn2", "author2", "publisher2");
		
		List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2));
		
		Mockito.when(bookService.getBooks()).thenReturn(bookList);
		
		//check in debug mode
		MvcResult mvcResult = mockMvc.perform(get("/api/books"))
//								.andExpect(status().isOk())
								.andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		System.out.println(mvcResult.getResponse().getStatus());
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		System.out.println("actualJsonResponse = " + actualJsonResponse);
		
		String expectedJsonResponse = objectMapper.writeValueAsString(bookList);
		System.out.println("expectedJsonResponse = " + expectedJsonResponse);
		
		assertThat(actualJsonResponse).isNotNull();
		assertThat(actualJsonResponse).isEqualTo(expectedJsonResponse);
	}
}
