package com.origin.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.origin.cafe.entity.Ord;
import com.origin.cafe.entity.OrderList;
import com.origin.cafe.service.OrdService;
import com.origin.cafe.service.OrderListService;

public class OrderListController {
	

	private OrderListService orderListService;
	
	@Autowired
	public OrderListController(OrderListService theOrderListService) {
		orderListService = theOrderListService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/orderLists")
	public List<OrderList> findAll() {
		return orderListService.findAll();
	}
	
	//add mapping for get /dishs/{dishDishNo} @PathVariable是用來獲得請求url中的動態引數的
	
	@GetMapping("/orderLists/{ordListOrdNo}")
	public OrderList getorderList(@PathVariable int ordOrdNo , int dishDishNo) {
		OrderList theOrderList = orderListService.findById(ordOrdNo , dishDishNo);
		
		if(theOrderList == null) {
			throw new RuntimeException("Order No. not found" +ordOrdNo);
		}
		
		return theOrderList;
	}
	
	//add dish for post /dishs - add new dish @RequestBody接收Json物件的字串
	
	@PostMapping("/orderLists")
	public OrderList addorderList(@RequestBody OrderList theOrderList) {
		
		theOrderList.setOrdNo(0);
		
		orderListService.save(theOrderList);
		
		return theOrderList;
	}
	
	//add mapping for PUT /dishs - update existing dish
	@PutMapping("/orders")
	public OrderList updateDish(@RequestBody OrderList theOrderList) {
		orderListService.save(theOrderList);
		
		return theOrderList;
	}
	
	//add mapping for DELETE /members - delete existing member
	@DeleteMapping("/orders/{ordOrdNo}")
	public String deleteOrder(@PathVariable int ordOrdNo , int dishDishNo) {
		
		OrderList tempOrderList = orderListService.findById(ordOrdNo ,dishDishNo);
		
		if(tempOrderList == null) {
			throw new RuntimeException("Order no. not found -" + ordOrdNo);
		}
		
		orderListService.deleteById(ordOrdNo ,dishDishNo);
		
		return "Delete order no. - " +tempOrderList;
	}
	
	
	
	
	
	
	
	

}
