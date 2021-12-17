package com.origin.cafe.service.impl;

import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.MemberFindReqDTO;
import com.origin.cafe.dto.MemberFindResDTO;
import com.origin.cafe.dto.MemberSaveReqDTO;
import com.origin.cafe.entity.Administrator;
import com.origin.cafe.entity.User;
import com.origin.cafe.repository.UserRepository;
import com.origin.cafe.service.MemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.origin.cafe.transfer.DTOTransfer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.entity.Member;
import com.origin.cafe.repository.MemberRepository;



@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberRepository memberRepository;


    public List<MemberFindResDTO> findMembers(MemberFindReqDTO memberFindReqDTO) {

        List<Member> members = null;

        if (StringUtils.isEmpty(memberFindReqDTO.getKeyWord()) && memberFindReqDTO.getMemberStatus() == null) {
            members = memberRepository.findAll();
        } else if (StringUtils.isEmpty(memberFindReqDTO.getKeyWord()) && memberFindReqDTO.getMemberStatus() != null) {
            members = memberRepository.findByMemStatusOrderByMemNoAsc(Byte.parseByte(String.valueOf(memberFindReqDTO.getMemberStatus())));//??要使用emun還是直接硬轉 目的是秀出狀態
        } else if (StringUtils.isNotEmpty(memberFindReqDTO.getKeyWord()) && memberFindReqDTO.getMemberStatus() == null) {
            members = memberRepository.findByKeyword(memberFindReqDTO.getKeyWord());
        } else {
            members = memberRepository.findByKeywordAndMemStatus(Byte.parseByte(String.valueOf(memberFindReqDTO.getMemberStatus())), memberFindReqDTO.getKeyWord());
        }

        List<MemberFindResDTO> memberFindResDTOs = new ArrayList<>();
        for (Member member : members) {
            Optional<User> optUser = userRepository.findByMemberMemNo(member.getMemNo());
            if (!optUser.isPresent()) {
                throw new RuntimeException("該會員帳號不存在喔.admNo:" + member.getMemNo());
            }
            MemberFindResDTO memberFindResDTO = DTOTransfer.memberEntityTransferMemberFindResDTO(member, optUser.get());
            memberFindResDTOs.add(memberFindResDTO);
        }
        return memberFindResDTOs;

    }

    @Override
    @Transactional
    public void saveMember(MemberSaveReqDTO memberSaveReqDTO) {

    Member member = null;


    Optional<Member> optMember = memberRepository.findById((memberSaveReqDTO.getMemNo()));
    if(optMember.isPresent()){
        member = optMember.get();
        member.setMemStatus(Byte.parseByte(memberSaveReqDTO.getMemberStatus()));
        member = memberRepository.save(member);

    }else{
        throw new RuntimeException("該會員不存在喔");
    }


    }


}
