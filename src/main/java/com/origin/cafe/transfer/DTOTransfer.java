package com.origin.cafe.transfer;


import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.entity.Administrator;
import com.origin.cafe.entity.Dish;

public class DTOTransfer {


  public static DishDTO dishEntityTransferDishDTO(Dish dish) {
    DishDTO dto = new DishDTO();
    dto.setDishNo(dish.getDishNo());
    dto.setDishName(dish.getDishName());
    dto.setDishType(dish.getDishType());
    dto.setDishPrice(dish.getDishPrice());
    dto.setDishQuantity(dish.getDishQuantity());
    dto.setDishStatus(String.valueOf(dish.getDishStatus()));

    return dto;

  }

  public static Dish dishDTOTransferDishEntity(DishDTO dishDTO) {

    Dish dish = new Dish();
    dish.setDishNo(dishDTO.getDishNo());
    dish.setDishImg(dishDTO.getDishImg());
    dish.setDishName(dishDTO.getDishName());
    dish.setDishPrice(dishDTO.getDishPrice());
    dish.setDishNote(dishDTO.getDishNote());
    dish.setDishStatus(Byte.valueOf(dishDTO.getDishStatus()));
    dish.setDishQuantity(dishDTO.getDishQuantity());
    dish.setCrDate(new java.sql.Date(new java.util.Date().getTime()));
    dish.setMdDate(new java.sql.Date(new java.util.Date().getTime()));
//    dish.setCrDate(Date.valueOf(dishDTO.getCrDate()));
//    dish.setMdDate(Date.valueOf(dishDTO.getMdDate()));
    dish.setDishType(dishDTO.getDishType());
    

    return dish;

  }

  public static AdminFindResDTO administratorEntityTransferAdminFindResDTO(Administrator administrator) {
    AdminFindResDTO dto = new AdminFindResDTO();
    dto.setAdmNo(administrator.getAdmNo());
    dto.setName(administrator.getAdmName());
    dto.setAddress(administrator.getAdmAddress());
    dto.setPhone(administrator.getAdmPhone());
    dto.setStatus(String.valueOf(administrator.getAdmStatus()));
    dto.setLevel(administrator.getAdmLevel().name());

    return dto;

  }

}
