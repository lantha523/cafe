package com.origin.cafe.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.service.DishService;

@RestController
@RequestMapping("/api")
public class DishRestController {
	@Autowired
	private DishService dishService;
//
//	@Autowired  //可以省略建構式並且直接裝配
//	public DishController(DishService theDishService) {
//		dishService = theDishService;
//	}
//
//	// expose "/employees" and return list of employees  
	//從這邊把取得的資料給ajex 再到checkmenu寫一段ajex呈現在畫面上 
		@GetMapping("/dishs")
		public List<DishDTO> findAll(Integer dishStatus) {
			return dishService.findAll(dishStatus);
		}

//		// add mapping for GET /dishs/{dishNo}
		
//		@GetMapping("/dishs/{dishNo}")
//		public DishDTO getDish(@PathVariable int dishNo) {
//			
//			DishDTO theDish = dishService.findById(dishNo);
//			
//			return theDish;
//		}
		
		// add mapping for POST /Dishs - add new Dish
		
//		@PostMapping("/dishs/add")
//		public DishDTO addDish(@RequestBody DishDTO theDishDTO) {
//			
//			// also just in case they pass an id in JSON ... set id to 0
//			// this is to force a save of new item ... instead of update
//			
//			theDishDTO.setDishNo(0);
//			
//			DishDTO newDishDTO = dishService.save(theDishDTO);
//			
//			return newDishDTO;
//		}
//		@GetMapping("/showDishFormForUpdate")
//		public String showDishFormForUpdate(@RequestParam("dishDishNo") int theDishNo , Model theModel) {
//			
//			//create medel attribute to bind for data
//			DishDTO theDishDTO =dishService.findById(theDishNo);
//			
//			theModel.addAttribute("dishsDTO", theDishDTO);
//			
//			return "manager/modify";		
//		}

	public static void main(String[] args) {
		System.out.println(SpringVersion.getVersion());
	}
}










