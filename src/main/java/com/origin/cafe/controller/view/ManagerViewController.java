package com.origin.cafe.controller.view;


import com.origin.cafe.config.SecurityUserUtils;
import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.service.DishService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view")
public class ManagerViewController {

	@Autowired
	private DishService dishService;
	
	@GetMapping("/manager/add")
	public String showDishFormForAdd(Model theModel) {
		
		//create medel attribute to bind for data
		DishDTO theDishDTO = new DishDTO();
		
		theModel.addAttribute("dishsDTO", theDishDTO);
		
		return "manager/add";		
	}

	@GetMapping("/manager/checkMenu")
	public String listDishsDTO(Model theModel) {
		
		List<DishDTO> theDishsDTO = dishService.findAll(1);
		
		theModel.addAttribute("dishsDTO",theDishsDTO);
		
		return "manager/checkmenu";	
		
	}
	
	@PostMapping("/manager/add/addDish")
	public String addDishList(@ModelAttribute("dishDTO") DishDTO theDishDTO) {
		
		dishService.save(theDishDTO);
		
		return "redirect:/view/manager/add";
		
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
	public String showDishFormForUpdate(Model theModel) {
		
		//create medel attribute to bind for data
		DishDTO theDishDTO = new DishDTO();
		
		theModel.addAttribute("dishsDTO", theDishDTO);
		
		return "manager/modify";		
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
