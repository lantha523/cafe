package com.origin.cafe.controller.view;


import com.origin.cafe.config.SecurityUserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class MemberViewController {

	@GetMapping("/member/account")
	public String account(Model theModel) {
		String userName = SecurityUserUtils.getUserName();
		System.out.println("path:/view/member/account, userName:" + userName); //此行可以取得帳號
		return "/member/account";
	}

	@GetMapping("/member/history")
	public String history(Model theModel) {
		return "/member/history";
	}

	@GetMapping("/member/order")
	public String order(Model theModel) {
		return "/member/order";
	}


}
