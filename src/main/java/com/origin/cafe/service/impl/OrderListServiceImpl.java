package com.origin.cafe.service.impl;

import com.origin.cafe.service.OrderListService;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.origin.cafe.entity.OrderList;
import com.origin.cafe.repository.OrderListRespository;

@Service
public class OrderListServiceImpl implements OrderListService {
	
	private OrderListRespository orderListRespository;
	
	public OrderListServiceImpl(OrderListRespository theOrderListRespository) {
		orderListRespository = theOrderListRespository;
		
	}

	@Override
	public List<OrderList> findAll() {
		// TODO Auto-generated method stub
		return orderListRespository.findAll();
	}

	@Override
	public OrderList findById(int theOrdNo, int theDishNo) {
//		Optional<OrderList> result = orderListRespository.findById(theOrdNo,theDishNo);
//		
//		OrderList theOrderList = null;
//		
//		if (result.isPresent()) {
//			theOrderList = result.get();
//		}
//		else {
//			// we didn't find the employee
//			throw new RuntimeException("Did not find employee id - " + theOrdNo,theDishNo);
//		}
		
		return null;	
		}

	@Override
	public void save(OrderList theOrderList) {
		orderListRespository.save(theOrderList);
	}

	@Override
	public void deleteById(int theOrdNo, int theDishNo) {
//		orderListRespository.deleteById(theOrdNo,theDishNo);

	}

}
