package com.origin.cafe.service;

import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import java.util.List;

public interface AdministratorService {

  List<AdminFindResDTO> findAdministrators(AdminFindReqDTO adminFindReqDTO);

}
