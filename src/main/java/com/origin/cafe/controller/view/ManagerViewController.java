package com.origin.cafe.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ManagerViewController {

	@GetMapping("/manager/add")
	public String add(Model theModel) {
			return "/manager/add";
	}

	@GetMapping("/manager/checkMenu")
	public String checkMenu(Model theModel) {
		return "/manager/checkmenu";
	}

	@GetMapping("/manager/checkOrder")
	public String checkOrder(Model theModel) {
		return "/manager/checkorder";
	}

	@GetMapping("/manager/item")
	public String item(Model theModel) {
		return "/manager/item";
	}

	@GetMapping("/manager/member")
	public String member(Model theModel) {
		return "/manager/member";
	}

	@GetMapping("/manager/modify")
	public String modify(Model theModel) {
		return "/manager/modify";
	}


}
