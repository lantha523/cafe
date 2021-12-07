package com.origin.cafe.service.impl;

import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.AdminSaveReqDTO;
import com.origin.cafe.entity.AdmAuthority;
import com.origin.cafe.entity.AdmFunction;
import com.origin.cafe.entity.Administrator;
import com.origin.cafe.entity.Member;
import com.origin.cafe.entity.User;
import com.origin.cafe.repository.AdmFunctionRepository;
import com.origin.cafe.repository.AdministratorRepository;
import com.origin.cafe.repository.MemberRepository;
import com.origin.cafe.repository.UserRepository;
import com.origin.cafe.service.AdministratorService;
import com.origin.cafe.transfer.DTOTransfer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

  @Autowired
  private AdministratorRepository administratorRepository;

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private AdmFunctionRepository admFunctionRepository;

  @Autowired
  private UserRepository userRepository;


  @Override
  public List<AdminFindResDTO> findAdministrators(AdminFindReqDTO adminFindReqDTO) {

    List<Administrator> administrators = null;

    if(StringUtils.isEmpty(adminFindReqDTO.getKeyWord()) && adminFindReqDTO.getLevel()==null){
      administrators = administratorRepository.findAll();

    }else if(StringUtils.isEmpty(adminFindReqDTO.getKeyWord()) && adminFindReqDTO.getLevel()!=null){
      administrators = administratorRepository.findByAdmLevelOrderByAdmNoAsc(adminFindReqDTO.getLevel());

    } else if (StringUtils.isNotEmpty(adminFindReqDTO.getKeyWord()) && adminFindReqDTO.getLevel()==null) {
      administrators = administratorRepository.findByKeyword(adminFindReqDTO.getKeyWord());

    }else{
      administrators = administratorRepository.findByKeywordAndLevel(adminFindReqDTO.getLevel().name(), adminFindReqDTO.getKeyWord());
    }

    List<AdminFindResDTO> adminFindResDTOs = new ArrayList<>();
    for (Administrator admin : administrators) {
      AdminFindResDTO adminFindResDTO = DTOTransfer.administratorEntityTransferAdminFindResDTO(admin);
      adminFindResDTOs.add(adminFindResDTO);
    }

    return adminFindResDTOs;
  }

  @Override
  @Transactional
  public void saveAdministrator(AdminSaveReqDTO adminSaveReqDTO) {

    List<AdmFunction> admFunctions = admFunctionRepository.findAllById(adminSaveReqDTO.getFunctionNos());
    Administrator administrator = null;
    List<AdmAuthority> admAuthorities = null;
    List<User> users =null;

    if(adminSaveReqDTO.getAdmNo() == null){
      Optional<User> optUser = userRepository.findByMemberMemNo(adminSaveReqDTO.getMemNo());
      if(optUser.isPresent()){
        if(optUser.get().getAdministrator() != null){
          throw new RuntimeException("該會員帳號已經綁定成為管理員了唷.");
        }
      }else{
        throw new RuntimeException("該會員帳號不存在喔.");
      }

      Optional<Member> optMember = memberRepository.findById(adminSaveReqDTO.getMemNo());
      if(optMember.isPresent()){
        Member member = optMember.get();

        administrator = new Administrator();
        administrator.setAdmName(member.getMemName());
        administrator.setAdmAddress(member.getMemAddress());
        administrator.setAdmPhone(member.getMemPhone());
        administrator.setAdmLevel(adminSaveReqDTO.getLevel());
        administrator.setAdmStatus((byte)1);

        admAuthorities = new ArrayList<>();
        for (AdmFunction admFunction : admFunctions){
          AdmAuthority admAuthority = new AdmAuthority();
          admAuthority.setAdministrator(administrator);
          admAuthority.setAdmFunction(admFunction);
          admAuthorities.add(admAuthority);
        }

        User user = member.getUsers().get(0);
        user.setAdministrator(administrator);
        users =new ArrayList<>();
        users.add(user);
        administrator.setUsers(users);

        administrator.setAdmAuthoritys(admAuthorities);
        administratorRepository.save(administrator);

      }else{
        throw new RuntimeException("該會員資料不存在喔.");
      }

    }else{
      Optional<Administrator> optAdministrator = administratorRepository.findById(adminSaveReqDTO.getAdmNo());
      if(optAdministrator.isPresent()){
        administrator = optAdministrator.get();
        administrator.setAdmLevel(adminSaveReqDTO.getLevel());
        administrator.getAdmAuthoritys().removeAll(administrator.getAdmAuthoritys());
        administrator = administratorRepository.save(administrator);

        admAuthorities = new ArrayList<>();
        for (AdmFunction admFunction : admFunctions){
          AdmAuthority admAuthority = new AdmAuthority();
          admAuthority.setAdministrator(administrator);
          admAuthority.setAdmFunction(admFunction);
          admAuthorities.add(admAuthority);
        }
        administrator.getAdmAuthoritys().addAll(admAuthorities);
        administratorRepository.save(administrator);

      }else{
        throw new RuntimeException("該管理員資料不存在喔.");
      }


    }
  }

  @Override
  @Transactional
  public void deleteAdministrator(Integer admNo) {
    administratorRepository.deleteById(admNo);
  }


}
