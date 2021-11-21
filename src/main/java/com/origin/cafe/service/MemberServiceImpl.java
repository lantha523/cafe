package com.origin.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.dao.MemberDao;
import com.origin.cafe.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	@Autowired //使用@Autowired注入dao的實例
	public MemberServiceImpl(MemberDao theMemberDao) {
		memberDao = theMemberDao;
	}

	@Override
	@Transactional
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberDao.findAll();
	}

	@Override
	@Transactional
	public Member findById(int theMemNo) {
		// TODO Auto-generated method stub
		return memberDao.findById(theMemNo);
	}

	@Override
	@Transactional
	public void save(Member theMember) {
		memberDao.save(theMember);

	}

	@Override
	@Transactional
	public void deleteById(int theMemNo) {
		memberDao.deleteById(theMemNo);

	}

}
