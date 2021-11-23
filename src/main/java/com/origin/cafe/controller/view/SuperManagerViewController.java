package com.origin.cafe.controller.view;


import com.origin.cafe.config.SecurityUserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class SuperManagerViewController {

	@GetMapping("/superManager/function")
	public String fuction(Model theModel) {
		String userId = SecurityUserUtils.getUserId();
		return "/superManager/function";
	}

	@GetMapping("/superManager/qualification")
	public String qualification(Model theModel) {
		return "/superManager/qualification";
	}


}
