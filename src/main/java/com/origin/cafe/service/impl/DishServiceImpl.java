package com.origin.cafe.service.impl;

import com.origin.cafe.service.DishService;

import com.origin.cafe.transfer.DTOTransfer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.dto.DishDTO;
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
	public List<DishDTO> findAll() {
	//先抓取list的資料
	List<Dish> dishList = dishRepository.findAll();
	//創造一個list的容器把上面的資料放進去迴圈裡add			
	List<DishDTO> dishDTOList = new ArrayList<DishDTO>();
	DishDTO dishDTO = null;
	
	for(Dish dish: dishList ) {	
	
		DishDTO dto = new DishDTO();
		dto.setDishNo(dish.getDishNo());
		dto.setDishName(dish.getDishName());
		dto.setDishType(dish.getDishType());
		dto.setDishPrice(dish.getDishPrice());
		dto.setDishQuantity(dish.getDishQuantity());
		dto.setDishStatus(dish.getDishStatus());
		dishDTOList.add(dto);
	}
	System.out.println("dishDTOList"+dishDTOList);
		return dishDTOList;
	}

	@Override //< Optional為了解決不要傳回null值的問題 這樣比較好除錯 > isPresent 假設有值則是True 不然就是False
	public DishDTO findById(int dishNo) {
		
		Optional<Dish> result = dishRepository.findById(dishNo);
		
		Dish theDish = null;
		
		if (result.isPresent()) {
			theDish = result.get();
		}else {
			throw new RuntimeException("not find No-"+dishNo);
		}

		DishDTO dishDTO = DTOTransfer.dishEntityTransferDishDTO(theDish);

		return dishDTO;
	}
//
//	@Override
//	public void save(DishDTO theDishDTO) {
//		dishRepository.save(theDishDTO);
//		
//	}
//
//	@Override
//	public void deleteById(int dishNo) {
//		dishRepository.deleteById(dishNo);		
//	}

	@Override
	public void save(DishDTO theDishDTO) {
		// TODO Auto-generated method stub

		Dish dish = DTOTransfer.dishDTOEntityTransferDishEntity(theDishDTO);

		dishRepository.save(dish);
		
	}

	@Override
	public void deleteById(int dishNo) {
		// TODO Auto-generated method stub

		dishRepository.deleteById(dishNo);
		
	}

}
