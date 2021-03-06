package com.origin.cafe.controller.view;


import com.origin.cafe.utils.SecurityUserUtils;
import com.origin.cafe.enums.Feature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class SuperManagerViewController {

	@GetMapping("/superManager/qualification")
	public String qualification(Model theModel) {
		if (!SecurityUserUtils.getUserDetails().getFeatureNos().contains(Feature.ADMINISTRATOR.getFeatureNo())) {
			return "/access-denied";
		}
		return "/superManager/qualification";
	}


}
