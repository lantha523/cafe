package com.origin.cafe.controller;

import java.util.List;

import com.origin.cafe.CafeException;
import com.origin.cafe.dto.*;
import com.origin.cafe.enums.CafeStatus;
import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;

@RequestMapping("/api/member")
@RestController
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/find")
    public CafeResponse findMembers(@Valid @RequestBody MemberFindReqDTO memberFindReqDTO) {
        try{
            List<MemberFindResDTO> memberFindResDTOs = memberService.findMembers(memberFindReqDTO);
            return CafeResponse.body(CafeStatus.OK, memberFindResDTOs, "success");
        }catch(CafeException e){
            return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
            return CafeResponse.body(CafeStatus.ERROR, null , "系統錯誤 請電聯客服");
        }
    }


    @PostMapping("/save")
    public CafeResponse saveMembers(@Valid @RequestBody MemberSaveReqDTO memberSaveReqDTO) {
        try{
            memberService.saveMember(memberSaveReqDTO);
            return CafeResponse.body(CafeStatus.OK, null, "success");

        }catch (CafeException e){
            return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
            return CafeResponse.body(CafeStatus.ERROR, null, "系統錯誤，請找客服人員！");
        }
    }

}
