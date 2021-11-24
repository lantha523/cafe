package com.origin.cafe.transfer;


import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.entity.Dish;

public class DTOTransfer {


  public static DishDTO dishEntityTransferDishDTO(Dish dish) {
    DishDTO dto = new DishDTO();
    dto.setDishNo(dish.getDishNo());
    dto.setDishName(dish.getDishName());
    dto.setDishType(dish.getDishType());
    dto.setDishPrice(dish.getDishPrice());
    dto.setDishQuantity(dish.getDishQuantity());
    dto.setDishStatus(dish.getDishStatus());

    return dto;

  }

  public static Dish dishDTOEntityTransferDishEntity(DishDTO dishDto) {

    Dish dish = new Dish();
    dish.setDishNo(dishDto.getDishNo());
    dish.setDishName();

    return dish;

  }

}
