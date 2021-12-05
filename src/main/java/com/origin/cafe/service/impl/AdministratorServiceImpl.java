package com.origin.cafe.service.impl;

import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.entity.Administrator;
import com.origin.cafe.repository.AdministratorRepository;
import com.origin.cafe.service.AdministratorService;
import com.origin.cafe.transfer.DTOTransfer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

@Service
public class AdministratorServiceImpl implements AdministratorService {

  @Autowired
  private AdministratorRepository administratorRepository;

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
}
