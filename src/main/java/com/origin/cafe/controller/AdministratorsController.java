package com.origin.cafe.controller;

import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.AdminSaveReqDTO;
import com.origin.cafe.dto.CafeResponse;
import com.origin.cafe.enums.CafeStatus;
import com.origin.cafe.service.AdministratorService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/administrator")
@RestController
public class AdministratorsController {

  @Autowired
  private AdministratorService administratorService;

  @PostMapping("/find")
  public CafeResponse findAdministrators(@Valid @RequestBody AdminFindReqDTO adminFindReqDTO) {
    try{
      List<AdminFindResDTO> adminFindResDTOs = administratorService.findAdministrators(adminFindReqDTO);
      return CafeResponse.body(CafeStatus.OK, adminFindResDTOs, "success");

    }catch (Exception e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }
  }

  @PostMapping("/save")
  public CafeResponse saveAdministrators(@Valid @RequestBody AdminSaveReqDTO adminSaveReqDTO) {
    try{
      administratorService.saveAdministrator(adminSaveReqDTO);
      return CafeResponse.body(CafeStatus.OK, null, "success");

    }catch (RuntimeException e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }catch (Exception e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }
  }

  @GetMapping("/delete")
  public CafeResponse deleteAdministrators(@RequestParam("admNo") Integer admNo) {
    try{
      administratorService.deleteAdministrator(admNo);
      return CafeResponse.body(CafeStatus.OK, null, "success");

    }catch (RuntimeException e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }catch (Exception e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }

  }

}
