package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByBName(String bname);
	 
	public List<Book> findByBAuthors(String bauthors);
}
