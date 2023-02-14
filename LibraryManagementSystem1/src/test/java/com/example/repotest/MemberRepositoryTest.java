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
import com.example.model.Member;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;


@SpringBootTest
public class MemberRepositoryTest {

	
	@MockBean
	private MemberRepository memberRepository;
	
	@Autowired(required=true)
	private MemberService memberService;
	
	
	@Test
	void testSaveMember() 
	{
		List<Book>bookList=Stream.of(new Book(101,11122,"Wings of fire","A p j Kalam", 549,"17/01/2023","19/01/2023"),
				new Book(102,11124,"Two States","Chetan Bhagat", 549,"18/01/2023","31/01/203")).collect(Collectors.toList());	
				Member m=new Member(101,"Rakhee","Pune","Rakhee123@gmail.com","8080830287","16/01/2023",bookList);
				Mockito.when(memberRepository.save(m)).thenReturn(m);
				assertEquals(m,memberService.CreateMember(m));
				
	}


	@Test
	void testAllMembers() 
	{
		List<Book> bookList=Stream
				.of(new Book(101,11122,"Wings of fire","A p j Kalam", 549,"17/01/2023","19/01/2023"),
						new Book(102,11123,"Two States","Chetan bhagat", 549,"22/01/2023","08/02/2023")).collect(Collectors.toList());
		List<Book> bookList1=Stream
				.of(new Book(101,11122,"Wings of fire","A p j Kalam", 549,"17/01/2023","19/01/2023"),
						new Book(102,11123,"Two States","Chetan bhagat", 549,"22/01/2023","08/02/2023"))
						.collect(Collectors.toList());
		
		
		List<Member> Member = Stream
				.of(new Member(101,"Rakhee","Pune","Rakhee123@gmail.com","8080830287","16/01/2023",bookList),
				new Member(102,"Rajshree","Pune","Rajshree123@gmail.com","7387737090","18/01/2023",bookList1)).collect(Collectors.toList());
				
		Mockito.when(memberRepository.findAll()).thenReturn(Member);
		assertEquals(2,memberService.findAllMember().size());
	}
	
	
	//Test Delete Method
	@Test
	void testDeleteStudent() 
	{
		memberService.deleteMember(101);
		Mockito.verify(memberRepository).deleteById(101);
	}

	
	
}
