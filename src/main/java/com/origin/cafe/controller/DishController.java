package com.origin.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.entity.Dish;
import com.origin.cafe.service.DishService;

@RestController
@RequestMapping("/api")
public class DishController {
	@Autowired
	private DishService dishService;
	
	@Autowired  //可以省略建構式並且直接裝配
	public DishController(DishService theDishService) {
		dishService = theDishService;
	}
	
//	// expose "/employees" and return list of employees
		@GetMapping("/dishs")
		public List<DishDTO> findAll() {
			return dishService.findAll();
		}

//		// add mapping for GET /dishs/{dishNo}
		
		@GetMapping("/dishs/{dishNo}")
		public DishDTO getDish(@PathVariable int dishNo) {
			
			DishDTO theDish = dishService.findById(dishNo);
			
			if (theDish == null) {
				throw new RuntimeException("Dish id not found - " + dishNo);
			}
			
			return theDish;
		}
		
		// add mapping for POST /Dishs - add new Dish
		
		@PostMapping("/dishs")
		public DishDTO addDish(@RequestBody DishDTO theDishDTO) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theDishDTO.setDishNo(0);
			
			dishService.save(theDishDTO);
			
			return theDishDTO;
		}
		
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
		
	
}
