package com.origin.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.origin.cafe.entity.Member;
import com.origin.cafe.service.MemberService;

@RestController // @RestController為了實現http方法
@RequestMapping("/api")
public class MemberController {
	
	private MemberService memberService;
	
	//quick and dirty inject member dao(use contructor injection)
	@Autowired
	public MemberController(MemberService theMemberService) {
		memberService = theMemberService;
		
	}
	
	//expose "/Members" and return list of members
	@GetMapping("/members")
	public List<Member> findAll() {
		return memberService.findAll();
		
	}
	
	//add mapping for get /members/{memberMemNo}--{自取名稱}
	
	@GetMapping("/members/{memberMemNo}")
	public Member getMember(@PathVariable int memberMemNo) {
		Member theMember = memberService.findById(memberMemNo);
		
		if (theMember == null) {
			throw new RuntimeException("Member No. not found-" + memberMemNo);
		}
		return theMember;
	}
	
	//add mapping for post /members - add new member
	
	@PostMapping("/members")
	public Member addMember(@RequestBody Member theMember) {
		
		//為了防止我們在json傳遞一個id要手動把值設定成0 這是強制保存新項目並插入
		
		theMember.setMemNo(0);
		
		memberService.save(theMember);
		
		return theMember;
		
	}
	
	//add mapping for PUT /members - update existing member
	@PutMapping("/members")
	public Member updateMember(@RequestBody Member theMember) {
		memberService.save(theMember);
		
		return theMember;
	}
	
	//add mapping for DELETE /members - delete existing member
	@DeleteMapping("/members/{memberMemNo}")
	public String deleteMember(@PathVariable int memberMemNo) {
		
		Member tempMember = memberService.findById(memberMemNo);
		
		//假如為空則丟出異常
		if (tempMember == null) {
			throw new RuntimeException("Member no. not found -" + memberMemNo);
		}
		
		memberService.deleteById(memberMemNo);
		
		return "Delete MEM no. -" + memberMemNo;
	}
	
	
	
	
}
