package com.origin.cafe.dao;

import java.util.List;

import com.origin.cafe.entity.Order;

public interface OrderDAO {
	
	public List<Order> findAll();
	
	public Order findById(int theOrdNo);
	
	public void save(Order theOrder);
	
	public void deleteById(int theOrdNo);

}
