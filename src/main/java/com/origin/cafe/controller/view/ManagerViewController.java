package com.origin.cafe.controller.view;


import com.origin.cafe.config.SecurityUserUtils;
import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.enums.Feature;
import com.origin.cafe.service.DishService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ManagerViewController {

	@Autowired
	private DishService dishService;
	
	@GetMapping("/manager/add")
	public String showDishFormForAdd(Model theModel) {
		if (!SecurityUserUtils.getUserDetails().getFeatureNos().contains(Feature.MENU.getFeatureNo())) {
			return "/access-denied";
		}
		//create medel attribute to bind for data
		DishDTO theDishDTO = new DishDTO();
		
		theModel.addAttribute("dishsDTO", theDishDTO);
		
		return "manager/add";		
	}

	@GetMapping("/manager/checkmenu")
	public String listDishsDTO(Model theModel) {

    if (!SecurityUserUtils.getUserDetails().getFeatureNos().contains(Feature.MENU.getFeatureNo())) {
			return "/access-denied";
		}
		
		List<DishDTO> theDishsDTO = dishService.findAll(null);//??
		
		theModel.addAttribute("dishsDTO",theDishsDTO);
		
		return "manager/checkmenu";	
		
	}
	
//	@PostMapping("/manager/add/addDish")
//	public String addDishList(@ModelAttribute("dishDTO") DishDTO theDishDTO) {
//		
//		dishService.save(theDishDTO);
//		
//		return "redirect:/view/manager/add";
//		
//	}
	
//	@GetMapping("/manager/add/addDish")
//	public String addDishList(@ModelAttribute("dishDTO") DishDTO theDishDTO) {
//		
//		return "manager/add";
//		
//	}


	@GetMapping("/manager/checkOrder")
	public String checkOrder(Model theModel) {
		if (!SecurityUserUtils.getUserDetails().getFeatureNos().contains(Feature.ORDEDR.getFeatureNo())) {
		  return "/access-denied";
	  }

		return "/manager/checkorder";
	}



	@GetMapping("/manager/member")
	public String member(Model theModel) {
		if (!SecurityUserUtils.getUserDetails().getFeatureNos().contains(Feature.MEMBER.getFeatureNo())) {
			return "/access-denied";
		}
		return "/manager/member";
	}


	
//	@GetMapping("/manager/modify")
//	public String showDishFormForUpdate(@RequestParam("dishDishNo") int theDishNo,Model theModel) {
//		
//		//create medel attribute to bind for data
//		DishDTO theDishDTO =dishService.findById(theDishNo);
//		
//		theModel.addAttribute("dishsDTO", theDishDTO);
//		
//		return "manager/modify";		
//	}


}
