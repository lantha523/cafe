package com.origin.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.dao.OrderDAO;
import com.origin.cafe.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO;
	
	@Autowired
	public OrderServiceImpl(OrderDAO theOrderDAO) {
		orderDAO = theOrderDAO;
		
	}

	@Override
	@Transactional
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	@Override
	public Order findById(int theOrdNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Order theOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theOrdNo) {
		// TODO Auto-generated method stub

	}

}
