package com.origin.cafe.service;

import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.AdminSaveReqDTO;
import java.util.List;

public interface AdministratorService {

  List<AdminFindResDTO> findAdministrators(AdminFindReqDTO adminFindReqDTO);

  void saveAdministrator(AdminSaveReqDTO adminSaveReqDTO);

  void deleteAdministrator(Integer admNo);

}
