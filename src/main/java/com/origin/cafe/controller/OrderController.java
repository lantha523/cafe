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

import com.origin.cafe.entity.Ord;
import com.origin.cafe.service.OrdService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	private OrdService orderService;
	
	@Autowired
	public OrderController(OrdService theOrderService) {
		orderService = theOrderService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/orders")
	public List<Ord> findAll() {
		return orderService.findAll();
	}
	
	//add mapping for get /dishs/{dishDishNo} @PathVariable是用來獲得請求url中的動態引數的
	
	@GetMapping("/orders/{ordOrdNo}")
	public Ord getOrd(@PathVariable int ordOrdNo) {
		Ord theOrd = orderService.findById(ordOrdNo);
		
		if(theOrd == null) {
			throw new RuntimeException("Order No. not found" +ordOrdNo);
		}
		
		return theOrd;
	}
	
	//add dish for post /dishs - add new dish @RequestBody接收Json物件的字串
	
	@PostMapping("/orders")
	public Ord addDish(@RequestBody Ord theOrder) {
		
		theOrder.setOrdNo(0);
		
		orderService.save(theOrder);
		
		return theOrder;
	}
	
	//add mapping for PUT /dishs - update existing dish
	@PutMapping("/orders")
	public Ord updateDish(@RequestBody Ord theOrder) {
		orderService.save(theOrder);
		
		return theOrder;
	}
	
	//add mapping for DELETE /members - delete existing member
	@DeleteMapping("/orders/{ordOrdNo}")
	public String deleteOrder(@PathVariable int ordOrdNo) {
		
		Ord tempOrder = orderService.findById(ordOrdNo);
		
		if(tempOrder == null) {
			throw new RuntimeException("Order no. not found -" + ordOrdNo);
		}
		
		orderService.deleteById(ordOrdNo);
		
		return "Delete order no. - " +ordOrdNo;
	}
	
	
	
	
	
	
	
	

}
