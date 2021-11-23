package com.origin.cafe.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class LoginViewController {

	@GetMapping("/login")
	public String login(Model theModel) {
			return "login";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "/access-denied";
	}
}
