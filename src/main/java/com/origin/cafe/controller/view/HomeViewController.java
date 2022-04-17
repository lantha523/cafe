package com.origin.cafe.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class HomeViewController {

	@GetMapping("/home")
	public String home(Model theModel) {
		System.out.println("welcome to home page!");
		return "index";
	}


}
