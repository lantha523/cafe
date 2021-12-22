package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.entity.Dish;

public interface DishService {
	
//	public List<DishDTO> findAll();
	
//	public Dish findById(int dishNo);
	public DishDTO findById(int dishNo);
	
//	public void save(Dish theDish);
	public DishDTO save(DishDTO theDishDTO);
	
	public void deleteById(int dishNo);
	
	//查詢餐點狀態
	public List<DishDTO> findByStatus(int dishStatus);

	//查詢餐點狀態和全部狀態
	List<DishDTO> findAll(Integer dishStatus);

}
