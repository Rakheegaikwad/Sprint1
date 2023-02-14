package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Book;



@Service
public interface BookService {

	
	public Book createBook(Book book);
	public List<Book> findAllBook();
	public void deleteBook(int id);
	public Book updateBook(Book book);
	public Book findBookById(int id);
	public List<Book> findByBookName(String name);
	public List<Book>findByBookAuthors(String author);
	
}
