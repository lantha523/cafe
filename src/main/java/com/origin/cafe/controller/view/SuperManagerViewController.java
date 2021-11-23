package com.origin.cafe.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class SuperManagerViewController {

	@GetMapping("/superManager/fuction")
	public String fuction(Model theModel) {
		return "/superManager/fuction";
	}

	@GetMapping("/superManager/qualification")
	public String qualification(Model theModel) {
		return "/superManager/qualification";
	}


}
