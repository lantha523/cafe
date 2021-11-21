package com.origin.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.origin.cafe.entity.Administrator;
import com.origin.cafe.service.AdministratorService;

@RestController // @RestController為了實現http方法
@RequestMapping("/api")
public class AdministratorsController {
	
	private AdministratorService administratorService;

	
	@Autowired
	public AdministratorsController(AdministratorService theAdministratorService) {
	
	administratorService = theAdministratorService;

}
	//查詢全部資料
	@GetMapping("/administrators")
	public List<Administrator> findAll() {
		
		return administratorService.findAll();
		}
	
	
	//取得一個no 查詢一筆資料
	@GetMapping("/administrators/{administratorAdmNo}")
	public Administrator getAdministrator(@PathVariable int administratorAdmNo) {
		
		Administrator theAdministrator = administratorService.findById(administratorAdmNo);
		
		if (theAdministrator == null) {
			throw new RuntimeException("Administrator id not found - " + administratorAdmNo);
		}
		
		return theAdministrator;
	}
	
	//add資料
	@PostMapping("/administrators")
	public Administrator addAdministrator(@RequestBody Administrator theAdministrator) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theAdministrator.setAdmNo(0);
		
		administratorService.save(theAdministrator);
		
		return theAdministrator;
	}
	
	//update資料
	@PutMapping("/administrators")
	public Administrator updateAdministrator(@RequestBody Administrator theAdministrator) {
		
		administratorService.save(theAdministrator);
		
		return theAdministrator;
	}
	
	//Delete資料
	@DeleteMapping("/administrators/{administratorAdmNo}")
	public String deleteAdministrator(@PathVariable int administratorAdmNo) {
		
		Administrator tempAdministrator = administratorService.findById(administratorAdmNo);
		
		// throw exception if null
		
		if (tempAdministrator == null) {
			throw new RuntimeException("Administrator id not found - " + administratorAdmNo);
		}
		
		administratorService.deleteById(administratorAdmNo);
		
		return "Deleted Administrator id - " + administratorAdmNo;
	}
	
	
	}
