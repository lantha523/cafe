package com.origin.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer>{

}
