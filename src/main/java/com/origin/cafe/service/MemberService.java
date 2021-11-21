package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.Member;

public interface MemberService {
	
	public List<Member> findAll();

	public Member findById(int theMemNo);
	
	public void save(Member theMember);
	
	public void deleteById(int theMemNo);
}
