package com.origin.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
