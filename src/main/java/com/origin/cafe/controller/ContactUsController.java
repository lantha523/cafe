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

import com.origin.cafe.entity.ContactUs;
import com.origin.cafe.service.ContactUsService;

@RestController // @RestController為了實現http方法
@RequestMapping("/api")
public class ContactUsController {
private ContactUsService contactUsService;

	
	@Autowired
	public ContactUsController(ContactUsService theContactUsService) {
	
	contactUsService = theContactUsService;

}
	//查詢全部資料
	@GetMapping("/contactUs")
	public List<ContactUs> findAll() {
		
		return contactUsService.findAll();
		}
	
	
	//取得一個no 查詢一筆資料
	@GetMapping("/contactUs/{contactUsConNo}")
	public ContactUs getContactUs(@PathVariable int contactUsConNo) {
		
		ContactUs theContactUs = contactUsService.findById(contactUsConNo);
		
		if (theContactUs == null) {
			throw new RuntimeException("ContactUs id not found - " + contactUsConNo);
		}
		
		return theContactUs;
	}
	
	//add資料
	@PostMapping("/contactUs")
	public ContactUs addContactUs(@RequestBody ContactUs theContactUs) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theContactUs.setConNo(0);
		
		contactUsService.save(theContactUs);
		
		return theContactUs;
	}
	
	//update資料
	@PutMapping("/contactUs")
	public ContactUs updateContactUs(@RequestBody ContactUs theContactUs) {
		
		contactUsService.save(theContactUs);
		
		return theContactUs;
	}
	
	//Delete資料
	@DeleteMapping("/contactUs/{contactUsConNo}")
	public String deleteContactUs(@PathVariable int contactUsConNo) {
		
		ContactUs tempContactUs = contactUsService.findById(contactUsConNo);
		
		// throw exception if null
		
		if (tempContactUs == null) {
			throw new RuntimeException("ContactUs id not found - " + contactUsConNo);
		}
		
		contactUsService.deleteById(contactUsConNo);
		
		return "Deleted ContactUs id - " + contactUsConNo;
	}
	
	
	}
