package com.origin.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.origin.cafe.entity.Order;
import com.origin.cafe.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService theOrderService) {
		orderService = theOrderService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/orders")
	public List<Order> findAll() {
		return orderService.findAll();
	}
	
	
	
	

}
