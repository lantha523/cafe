package com.origin.cafe.transfer;


import com.origin.cafe.dto.AdminFindResDTO;
import com.origin.cafe.dto.DishDTO;
import com.origin.cafe.dto.FeatureDTO;
import com.origin.cafe.entity.AdmAuthority;
import com.origin.cafe.entity.AdmFunction;
import com.origin.cafe.entity.Administrator;
import com.origin.cafe.entity.Dish;
import com.origin.cafe.entity.User;
import java.util.ArrayList;
import java.util.List;

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

  public static AdminFindResDTO administratorEntityTransferAdminFindResDTO(Administrator administrator, User user) {
    AdminFindResDTO dto = new AdminFindResDTO();
    dto.setAdmNo(administrator.getAdmNo());
    dto.setMemNo(user.getMember().getMemNo());
    dto.setUserName(user.getUsername());
    dto.setName(administrator.getAdmName());
    dto.setAddress(administrator.getAdmAddress());
    dto.setPhone(administrator.getAdmPhone());
    dto.setStatus(String.valueOf(administrator.getAdmStatus()));
    dto.setLevel(administrator.getAdmLevel().name());

    List<FeatureDTO> featureDTOs = new ArrayList<>();
    for (AdmAuthority adah : administrator.getAdmAuthoritys()) {
      FeatureDTO featureDTO = admFunctionEntityTransferFeatureDTO(adah.getAdmFunction());
      featureDTOs.add(featureDTO);
    }
    dto.setFeatures(featureDTOs);

    return dto;

  }

  public static FeatureDTO admFunctionEntityTransferFeatureDTO(AdmFunction admFunction) {
    FeatureDTO dto = new FeatureDTO();
    dto.setFunctionNo(admFunction.getFunctionNo());
    dto.setFunctionName(admFunction.getFunctionDetail());

    return dto;
  }


}
