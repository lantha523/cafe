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

import com.origin.cafe.entity.AdmFunction;
import com.origin.cafe.service.AdmFunctionService;

@RestController // @RestController為了實現http方法
@RequestMapping("/api")
public class AdmFunctionController {
	
private AdmFunctionService admFunctionService;

	
	@Autowired
	public AdmFunctionController(AdmFunctionService theAdmFunctionService) {
	
		admFunctionService = theAdmFunctionService;

}
	//查詢全部資料
	@GetMapping("/admFunctions")
	public List<AdmFunction> findAll() {
		
		return admFunctionService.findAll();
		}
	
	
	//取得一個no 查詢一筆資料
	@GetMapping("/admFunctions/{admFunctionAdmNo}")
	public AdmFunction getAdmFunction(@PathVariable int admFunctionAdmNo) {
		
		AdmFunction theAdmFunction = admFunctionService.findById(admFunctionAdmNo);
		
		if (theAdmFunction == null) {
			throw new RuntimeException("AdmFunction id not found - " + admFunctionAdmNo);
		}
		
		return theAdmFunction;
	}
	
	//add資料
	@PostMapping("/admFunctions")
	public AdmFunction addAdmFunction(@RequestBody AdmFunction theAdmFunction) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theAdmFunction.setFunctionNo(0);
		
		admFunctionService.save(theAdmFunction);
		
		return theAdmFunction;
	}
	
	//update資料
	@PutMapping("/admFunctions")
	public AdmFunction updateAdmFunction(@RequestBody AdmFunction theAdmFunction) {
		
		admFunctionService.save(theAdmFunction);
		
		return theAdmFunction;
	}
	
	//Delete資料
	@DeleteMapping("/admFunctions/{admFunctionAdmNo}")
	public String deleteAdmFunction(@PathVariable int admFunctionAdmNo) {
		
		AdmFunction tempAdmFunction = admFunctionService.findById(admFunctionAdmNo);
		
		// throw exception if null
		
		if (tempAdmFunction == null) {
			throw new RuntimeException("AdmFunction id not found - " + admFunctionAdmNo);
		}
		
		admFunctionService.deleteById(admFunctionAdmNo);
		
		return "Deleted AdmFunction id - " + admFunctionAdmNo;
	}

}
