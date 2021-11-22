package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.OrderList;

public interface OrderListService {
	
	public List<OrderList> findAll();
	
	public OrderList findById(int theOrdNo,int theDishNo);
	
	public void save(OrderList theOrderList);
	
	public void deleteById(int theOrdNo,int theDishNo);

}
