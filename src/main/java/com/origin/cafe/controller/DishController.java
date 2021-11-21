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

import com.origin.cafe.entity.Dish;
import com.origin.cafe.service.DishService;

@RestController  // @RestController為了實現http方法
@RequestMapping("/api")
public class DishController {
	
	private DishService dishService;
	
	@Autowired //來注入Dao的實例。
	public DishController(DishService theDishService) {
		dishService = theDishService;
	}
	
	//連接 "/dishs" and return 清單 of dishs
	@GetMapping("/dishs")
	public List<Dish> findAll() {
		return dishService.findAll();
	}
	
	//add mapping for get /dishs/{dishDishNo} @PathVariable是用來獲得請求url中的動態引數的
	
	@GetMapping("/dishs/{dishDishNo}")
	public Dish getDish(@PathVariable int dishDishNo) {
		Dish theDish = dishService.findById(dishDishNo);
		
		if(theDish == null) {
			throw new RuntimeException("Dish No. not found" +dishDishNo);
		}
		
		return theDish;
	}
	
	//add dish for post /dishs - add new dish @RequestBody接收Json物件的字串
	
	@PostMapping("/dishs")
	public Dish addDish(@RequestBody Dish theDish) {
		
		theDish.setDishNo(0);
		
		dishService.save(theDish);
		
		return theDish;
	}
	
	//add mapping for PUT /dishs - update existing dish
	@PutMapping("/dishs")
	public Dish updateDish(@RequestBody Dish theDish) {
		dishService.save(theDish);
		
		return theDish;
	}
	
	//add mapping for DELETE /members - delete existing member
	@DeleteMapping("/dishs/{dishDishNo}")
	public String deleteDish(@PathVariable int dishDishNo) {
		
		Dish tempDish = dishService.findById(dishDishNo);
		
		if(tempDish == null) {
			throw new RuntimeException("Dish no. not found -" + dishDishNo);
		}
		
		dishService.deleteById(dishDishNo);
		
		return "Delete dish no. - " +dishDishNo;
	}
	
	
	
	

}
