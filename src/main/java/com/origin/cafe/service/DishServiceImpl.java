package com.origin.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.dao.DishDAO;
import com.origin.cafe.entity.Dish;

@Service
public class DishServiceImpl implements DishService {
	
	private DishDAO dishDAO;
	
	@Autowired //使用@Autowired注入dao的實例
	public DishServiceImpl(DishDAO theDishDAO) {
		
		dishDAO = theDishDAO;
	}

	@Override
	@Transactional
	public List<Dish> findAll() {
		// TODO Auto-generated method stub
		return dishDAO.findAll();
	}

	@Override
	@Transactional
	public Dish findById(int theDishNo) {
		// TODO Auto-generated method stub
		return dishDAO.findById(theDishNo);
	}

	@Override
	@Transactional
	public void save(Dish theDish) {
		dishDAO.save(theDish);
	}

	@Override
	@Transactional
	public void deleteById(int theDishNo) {
		dishDAO.deleteById(theDishNo);

	}

}
