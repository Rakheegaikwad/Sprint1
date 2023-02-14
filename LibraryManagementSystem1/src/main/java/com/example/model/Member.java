package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity

public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Member_id;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String MName;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String Member_Address;
	
	@Email(message = "Invalid email")
	private String MEmail;
	
	@NotBlank(message = "Invalid Phone number: Empty number")
	@NotNull(message = "Invalid Phone number: Number is NULL")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
	private String Member_Phone_Number;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern ="dd/MM/yyyy")
	private  String Member_Joined_Date;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Book>bookList;

	public Member() {
		
	}

	public Member(int member_id,
			@NotBlank(message = "Invalid Name: Empty name") @NotNull(message = "Invalid Name: Name is NULL") @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters") String mName,
			@NotBlank(message = "Invalid Name: Empty name") @NotNull(message = "Invalid Name: Name is NULL") @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters") String member_Address,
			@Email(message = "Invalid email") String mEmail,
			@NotBlank(message = "Invalid Phone number: Empty number") @NotNull(message = "Invalid Phone number: Number is NULL") @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number") String member_Phone_Number,
			String member_Joined_Date, List<Book> bookList) {
		super();
		Member_id = member_id;
		MName = mName;
		Member_Address = member_Address;
		MEmail = mEmail;
		Member_Phone_Number = member_Phone_Number;
		Member_Joined_Date = member_Joined_Date;
		this.bookList = bookList;
	}

	public int getMember_id() {
		return Member_id;
	}

	public void setMember_id(int member_id) {
		Member_id = member_id;
	}

	public String getMName() {
		return MName;
	}

	public void setMName(String mName) {
		MName = mName;
	}

	public String getMember_Address() {
		return Member_Address;
	}

	public void setMember_Address(String member_Address) {
		Member_Address = member_Address;
	}

	public String getMEmail() {
		return MEmail;
	}

	public void setMEmail(String mEmail) {
		MEmail = mEmail;
	}

	public String getMember_Phone_Number() {
		return Member_Phone_Number;
	}

	public void setMember_Phone_Number(String member_Phone_Number) {
		Member_Phone_Number = member_Phone_Number;
	}

	public String getMember_Joined_Date() {
		return Member_Joined_Date;
	}

	public void setMember_Joined_Date(String member_Joined_Date) {
		Member_Joined_Date = member_Joined_Date;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
	
	
	
	
	
}
