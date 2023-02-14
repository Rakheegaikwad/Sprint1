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

import com.example.model.Member;
import com.example.service.MemberService;



@RestController
@RequestMapping(value="/member")
public class MemberController {

	@Autowired(required=true)
	MemberService memberService;
	
	@PostMapping(value="/membervalid")
	public ResponseEntity<Member> addValidMember(@Valid @RequestBody Member member)
	{
		
		return new ResponseEntity<Member>(memberService.CreateMember(member),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/member")
	public List<Member> findAllMember()
	{
		return memberService.findAllMember();
		
	}
	
	@GetMapping(value="/member/{id}")
	public Member findPatientById(@PathVariable int id)
	{
		return memberService.findMemberById(id);
	
	}
	
	@GetMapping(value="/member/api/{name}")
	public List<Member> findByPatientName(@PathVariable String name)
	{
		return memberService.findByMemberName(name);
	}
	
	
	@GetMapping(value="/patient/email/{email}")
	public List<Member>findByPatientEmail(@PathVariable String email)
	{
		return memberService.findByMemberEmail(email);
	}
	
	
	@DeleteMapping(value="/member/{id}")
	public String deleteMember(@PathVariable int id)
	{
		return memberService.deleteMember(id);
	}
	
	
	@PutMapping(value="/member")
	public Member updateMember(@RequestBody Member member)
	{
		return memberService.updateMember(member);
	}
}