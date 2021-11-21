package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.Dish;

public interface DishService {
	
	public List<Dish> findAll();
	
	public Dish findById(int theDishNo);
	
	public void save(Dish theDish);
	
	public void deleteById(int theDishNo);

}
