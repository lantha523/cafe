package com.origin.cafe.service.impl;

import com.origin.cafe.service.DishService;
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
	
	@Autowired
	public DishServiceImpl(DishRepository theDishRepository) {
		dishRepository = theDishRepository;
	}

	@Override
	public List<Dish> findAll() {
		// TODO Auto-generated method stub
		return dishRepository.findAll();
	}

	@Override //< Optional為了解決不要傳回null值的問題 這樣比較好除錯 > isPresent 假設有值則是True 不然就是False
	public Dish findById(int dishNo) {
		
		Optional<Dish> result = dishRepository.findById(dishNo);
		
		Dish theDish = null;
		
		if (result.isPresent()) {
			theDish = result.get();
		}else {
			throw new RuntimeException("not find No-"+dishNo);
		}
		
		return theDish;
	}

	@Override
	public void save(Dish theDish) {
		dishRepository.save(theDish);
		
	}

	@Override
	public void deleteById(int dishNo) {
		dishRepository.deleteById(dishNo);		
	}

}
