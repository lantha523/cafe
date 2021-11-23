package com.origin.cafe.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class CartViewController {

	@GetMapping("/cart")
	public String cart(Model theModel) {
			return "member/payment";
	}


}
