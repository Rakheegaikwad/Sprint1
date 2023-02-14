package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService
{
	@Autowired(required=true)
	MemberRepository memberRepository;
	
	
	@Override
	public Member CreateMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	@Override
	public List<Member> findAllMember() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	@Override
	public String deleteMember(int id) {
		// TODO Auto-generated method stub
		memberRepository.deleteById(id);
		return "Member is Deleted";
	}

	@Override
	public Member updateMember(Member member) {
		// TODO Auto-generated method stub
		Member _member=memberRepository.findById(member.getMember_id()).get();
		_member.setMember_id(member.getMember_id());
		_member.setMName(member.getMName());
		_member.setMEmail(member.getMEmail());
		_member.setMember_Address(member.getMember_Address());
		_member.setMember_Phone_Number(member.getMember_Phone_Number());
		
		return memberRepository.save(_member);
	}

	@Override
	public Member findMemberById(int id) {
		// TODO Auto-generated method stub
		return memberRepository.findById(id).get();
	}

	@Override
	public List<Member> findByMemberName(String name) {
		// TODO Auto-generated method stub
		return memberRepository.findByMName(name);
	}

	@Override
	public List<Member> findByMemberEmail(String email) {
		// TODO Auto-generated method stub
		return memberRepository.findByMEmail(email);
	}
	
}
