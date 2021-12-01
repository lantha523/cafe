package com.origin.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.entity.Dish;
import com.origin.cafe.service.DishService;

//@RestController
@Controller
@RequestMapping("/api")
public class DishController {
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
//		@GetMapping("/dishs")
//		public List<DishDTO> findAll() {
//			return dishService.findAll();
//		}
//
////		// add mapping for GET /dishs/{dishNo}
//		
//		@GetMapping("/dishs/{dishNo}")
//		public DishDTO getDish(@PathVariable int dishNo) {
//			
//			DishDTO theDish = dishService.findById(dishNo);
//			
//			return theDish;
//		}
//		
//		// add mapping for POST /Dishs - add new Dish
//		
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
		
		// add mapping for PUT /Dishs - update existing Dish
		
//		@PutMapping("/dishs")
//		public Dish updateDish(@RequestBody Dish theDish) {
//			
//			dishService.save(theDish);
//			
//			return theDish;
//		}
		
		// add mapping for DELETE /Dishs/{dishNo} - delete Dish
		
//		@DeleteMapping("/dishs/{dishNo}")
//		public String deleteDish(@PathVariable int dishNo) {
//			
//			Dish tempDish = dishService.findById(dishNo);
//			
//			// throw exception if null
//			
//			if (tempDish == null) {
//				throw new RuntimeException("Dish id not found - " + dishNo);
//			}
//			
//			dishService.deleteById(dishNo);
//			
//			return "Deleted dish id - " + dishNo;
//		}
//		@GetMapping("/dishLists")
//		public String listDishsDTO(Model theModel) {
//	    //
//			List<DishDTO> theDishsDTO = dishService.findAll();
//			
//			theModel.addAttribute("dishsDTO",theDishsDTO);
//			
//			return "manager/checkmenu";	
//			
//		}
//		
//		@GetMapping("/showDishFormForAdd")
//		public String showDishFormForAdd(Model theModel) {
//			
//			//create medel attribute to bind for data
//			DishDTO theDishDTO = new DishDTO();
//			
//			theModel.addAttribute("dishsDTO", theDishDTO);
//			
//			return "manager/add";		
//		}
	
		@PostMapping("/addDish")
		public String addDishList(@ModelAttribute("dishDTO") DishDTO theDishDTO) {
			
			dishService.save(theDishDTO);
			
			return "redirect:/view/manager/add";
			
		}
		
		@GetMapping("/showDishFormForUpdate")
		public String showDishFormForUpdate(@RequestParam("dishDishNo") int theDishNo, Model theModel) {
			
			//create medel attribute to bind for data

			DishDTO theDishDTO = dishService.findById(theDishNo);
			
			theModel.addAttribute("dishsDTO", theDishDTO);
			
			return "manager/modify";		
		}
		
		@PostMapping("/update")
		public String updateDishList(@ModelAttribute("dishDTO") DishDTO theDishDTO) {
			
			dishService.save(theDishDTO);
			
			return "redirect:/view/manager/checkmenu";
			
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam("dishDishNo") int theDishNo) {
			
			//delete the emp
			dishService.deleteById(theDishNo);
			
			//redirect to employees/list
			return "redirect:/view/manager/checkmenu";
		}
		
//		@GetMapping("/showDishType")
//		public String showDishType(Model theModel) {
//			
//			
//			
//		}
		
		
//		@PostMapping("/list/addDish")
//		public String addDishList(@ModelAttribute("dishDTO") DishDTO theDishDTO) {
//			
//			dishService.save(theDishDTO);
//			
//			return "redirect:/api/dishLists";
//			
//		}
		
	
}
