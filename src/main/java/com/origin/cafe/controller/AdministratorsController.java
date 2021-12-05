package com.origin.cafe.controller;

import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.service.AdministratorService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/administrator")
@RestController
public class AdministratorsController {

  @Autowired
  private AdministratorService administratorService;

  @PostMapping("/find")
  public List<AdminFindResDTO> findAdministrators(@Valid @RequestBody AdminFindReqDTO adminFindReqDTO) {
    return administratorService.findAdministrators(adminFindReqDTO);
  }

}
