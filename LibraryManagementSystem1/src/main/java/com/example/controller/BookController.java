package com.example.controller;



import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.service.BookService;


@RestController

public class BookController
{
	@Autowired(required=true)
	private BookService bookService;
	
	@PostMapping(value="/booksvalid")
	public ResponseEntity<Book> addValidBook(@Valid @RequestBody Book book)
	{
		return new ResponseEntity<Book>(bookService.createBook(book),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/book")
	public List<Book> findAllBooks()
	{
		return bookService.findAllBook();
	}
	
	@GetMapping(value="/book/{id}")
	public Book findBookById(@PathVariable int id)
	{
		return bookService.findBookById(id);
	
	}
	
	@GetMapping(value="/book/name/{name}")
	public List<Book> findByBookName(@PathVariable String name)
	{
		return bookService.findByBookName(name);
	}
	
	
	@GetMapping(value="/book/email/{email}")
	public List<Book>findByBookAuthors(@PathVariable String author)
	{
		return bookService.findByBookAuthors(author);
	}
	
	
	@DeleteMapping(value="/book/{id}")
	public void deleteBook(@PathVariable int id)
	{
		 bookService.deleteBook(id);
		
	}
	
	@PutMapping(value="/book")
	public Book updateBook(@RequestBody Book book)
	{
		return bookService.updateBook(book);
	}

}
