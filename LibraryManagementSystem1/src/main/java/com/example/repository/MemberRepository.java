package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member ,Integer>{
	public List<Member> findByMName(String mname);
	 
	public List<Member> findByMEmail(String memail);
}
