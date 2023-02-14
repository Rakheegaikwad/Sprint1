package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired(required=true)
	private BookRepository bookRepository;
	
	
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
		
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
	 	bookRepository.deleteById(id);
		
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		Book _book=bookRepository.findById(book.getBook_Id()).get();
		
		_book.setBName(book.getBName());
		_book.setBook_ISBN_No(book.getBook_ISBN_No());
		_book.setBAuthors(book.getBAuthors());
		_book.setBook_Price(book.getBook_Price());
		_book.setBook_Borrow_Date(book.getBook_Return_Date());
		_book.setBook_Return_Date(book.getBook_Return_Date());
		return bookRepository.save(_book);
	}

	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> findByBookName(String name) {
		// TODO Auto-generated method stub
		return bookRepository.findByBName(name);
	}

	@Override
	public List<Book> findByBookAuthors(String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByBAuthors(author);
	}
	
}
