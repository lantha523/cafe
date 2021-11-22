package com.origin.cafe.service.impl;

import com.origin.cafe.service.MemberService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.entity.Member;
import com.origin.cafe.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired //使用@Autowired注入dao的實例
	public MemberServiceImpl(MemberRepository theMemberRepository) {
		memberRepository = theMemberRepository;
	}

	@Override
	@Transactional
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	@Override
	@Transactional
	public Member findById(int theMemNo) {
		// 圈選 administratorRepository.findById(theAdmNo);右鍵refactor-->extrack local variable重構成result 
		Optional<Member> result = memberRepository.findById(theMemNo);
		
		Member theMember = null;
		
		if (result.isPresent()) {
			theMember = result.get();
		}else {
			throw new RuntimeException("Did not find Member Id-" + theMemNo);
		}
		return theMember;	}

	@Override
	@Transactional
	public void save(Member theMember) {
		memberRepository.save(theMember);

	}

	@Override
	@Transactional
	public void deleteById(int theMemNo) {
		memberRepository.deleteById(theMemNo);

	}

}
