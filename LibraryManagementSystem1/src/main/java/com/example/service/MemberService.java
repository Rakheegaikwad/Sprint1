package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Member;



@Service
public interface MemberService {
 
	public Member CreateMember(Member member);
	public List<Member> findAllMember();
	public String deleteMember(int id);
	public Member updateMember(Member member);
	public Member findMemberById(int id);
	public List<Member> findByMemberName(String name);
	public List<Member>findByMemberEmail(String email);
}
