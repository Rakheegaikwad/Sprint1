package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity

public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Book_Id;
	private int Book_ISBN_No;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String BName;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String BAuthors;
	
	private int Book_Price;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern ="dd/MM/yyyy")
	private String Book_Borrow_Date;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern ="dd/MM/yyyy")
	private String Book_Return_Date;

	public Book() {
		
	}

	public Book(int book_Id, int book_ISBN_No,
			@NotBlank(message = "Invalid Name: Empty name") @NotNull(message = "Invalid Name: Name is NULL") @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters") String bName,
			@NotBlank(message = "Invalid Name: Empty name") @NotNull(message = "Invalid Name: Name is NULL") @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters") String bAuthors,
			int book_Price, String book_Borrow_Date, String book_Return_Date) {
		super();
		Book_Id = book_Id;
		Book_ISBN_No = book_ISBN_No;
		BName = bName;
		BAuthors = bAuthors;
		Book_Price = book_Price;
		Book_Borrow_Date = book_Borrow_Date;
		Book_Return_Date = book_Return_Date;
	}

	public int getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(int book_Id) {
		Book_Id = book_Id;
	}

	public int getBook_ISBN_No() {
		return Book_ISBN_No;
	}

	public void setBook_ISBN_No(int book_ISBN_No) {
		Book_ISBN_No = book_ISBN_No;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public String getBAuthors() {
		return BAuthors;
	}

	public void setBAuthors(String bAuthors) {
		BAuthors = bAuthors;
	}

	public int getBook_Price() {
		return Book_Price;
	}

	public void setBook_Price(int book_Price) {
		Book_Price = book_Price;
	}

	public String getBook_Borrow_Date() {
		return Book_Borrow_Date;
	}

	public void setBook_Borrow_Date(String book_Borrow_Date) {
		Book_Borrow_Date = book_Borrow_Date;
	}

	public String getBook_Return_Date() {
		return Book_Return_Date;
	}

	public void setBook_Return_Date(String book_Return_Date) {
		Book_Return_Date = book_Return_Date;
	}
	
	
	
	
	
	
}
