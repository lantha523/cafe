package com.origin.cafe.controller;

import com.origin.cafe.CafeException;
import com.origin.cafe.dto.AdminFindReqDTO;
import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.AdminSaveReqDTO;
import com.origin.cafe.dto.CafeResponse;
import com.origin.cafe.enums.CafeStatus;
import com.origin.cafe.service.AdministratorService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/administrator")
@RestController
@Slf4j
public class AdministratorsController {

  @Autowired
  private AdministratorService administratorService;

  @PostMapping("/find")
  public CafeResponse findAdministrators(@Valid @RequestBody AdminFindReqDTO adminFindReqDTO) {
    try{
      List<AdminFindResDTO> adminFindResDTOs = administratorService.findAdministrators(adminFindReqDTO);
      return CafeResponse.body(CafeStatus.OK, adminFindResDTOs, "success");

    }catch (CafeException e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }catch (Exception e){
      log.error(e.getMessage());
      return CafeResponse.body(CafeStatus.ERROR, null, "系統錯誤，請找客服人員！");
    }
  }

  @PostMapping("/save")
  public CafeResponse saveAdministrators(@Valid @RequestBody AdminSaveReqDTO adminSaveReqDTO) {
    try{
      administratorService.saveAdministrator(adminSaveReqDTO);
      return CafeResponse.body(CafeStatus.OK, null, "success");

    }catch (CafeException e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }catch (Exception e){
      log.error(e.getMessage());
      return CafeResponse.body(CafeStatus.ERROR, null, "系統錯誤，請找客服人員！");
    }
  }

  @GetMapping("/delete")
  public CafeResponse deleteAdministrators(@RequestParam("admNo") Integer admNo) {
    try{
      administratorService.deleteAdministrator(admNo);
      return CafeResponse.body(CafeStatus.OK, null, "success");

    }catch (CafeException e){
      return CafeResponse.body(CafeStatus.ERROR, null, e.getMessage());
    }catch (Exception e){
      log.error(e.getMessage());
      return CafeResponse.body(CafeStatus.ERROR, null, "系統錯誤，請找客服人員！");
    }

  }

}
