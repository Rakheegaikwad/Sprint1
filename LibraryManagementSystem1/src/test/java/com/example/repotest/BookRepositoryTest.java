package com.example.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;


@SpringBootTest
public class BookRepositoryTest {

	
	@MockBean
	private BookRepository bookRepository;
	
	@Autowired(required=true)
	private BookService bookService;
	
	
	@Test
	void testSaveBook() 
	{
		Book b = new Book(101,11122,"Wings of fire","A p j Kalam", 549,"17/01/2023","19/01/2023");
		Mockito.when(bookRepository.save(b)).thenReturn(b);
		assertEquals(b, bookService.createBook(b));
	}


	@Test
	void testAllBooks() 
	{
		List<Book>Book=Stream.of(new Book(101,11122,"Wings of fire","A p j Kalam", 549,"17/01/2023","19/01/2023"),
			new Book(102,11123," two States","Chetan Bhagat",649,"18/01/2023","21/01/2023"))
			.collect(Collectors.toList());
		Mockito.when(bookRepository.findAll()).thenReturn(Book);
		assertEquals(2,bookService.findAllBook().size());
		
	}
	//Test DeleteExam Method
	@Test
	void testDeleteStudent() 
	{
		bookService.deleteBook(101);
		Mockito.verify(bookRepository).deleteById(101);
	}


}
