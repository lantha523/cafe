package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.dto.AdminSaveReqDTO;
import com.origin.cafe.dto.MemberFindReqDTO;
import com.origin.cafe.dto.MemberFindResDTO;
import com.origin.cafe.dto.MemberSaveReqDTO;
import com.origin.cafe.entity.Member;

public interface MemberService {

    List<MemberFindResDTO> findMembers(MemberFindReqDTO memberFindReqDTO);

    void saveMember(MemberSaveReqDTO memberSaveReqDTO);

}
