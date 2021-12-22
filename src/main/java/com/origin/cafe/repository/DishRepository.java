package com.origin.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer>{
	
	 @Query(value = "SELECT * FROM dish where dish_status =?;", nativeQuery = true)
	 List<Dish> findByDishStatus(Integer dish_status);


}
