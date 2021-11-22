package com.origin.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.entity.Dish;
import com.origin.cafe.repository.DishRepository;

@Service
public class DishServiceImpl implements DishService {
	
	private DishRepository dishRepository;
	
	@Autowired //使用@Autowired注入dao的實例
	public DishServiceImpl(DishRepository theDishRepository) {
		
		dishRepository = theDishRepository;
	}

	@Override
	@Transactional
	public List<Dish> findAll() {
		// TODO Auto-generated method stub
		return dishRepository.findAll();
	}

	@Override
	@Transactional
	public Dish findById(int theDishNo) {
		// 圈選 administratorRepository.findById(theAdmNo);右鍵refactor-->extrack local variable重構成result 
		Optional<Dish> result = dishRepository.findById(theDishNo);
		
		Dish theDish = null;
		
		if (result.isPresent()) {
			theDish = result.get();
		}else {
			throw new RuntimeException("Did not find emp Id-" + theDishNo);
		}
		return theDish;
	}
	@Override
	@Transactional
	public void save(Dish theDish) {
		dishRepository.save(theDish);
	}

	@Override
	@Transactional
	public void deleteById(int theDishNo) {
		dishRepository.deleteById(theDishNo);

	}

}
