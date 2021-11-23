package com.origin.cafe.dto;

import com.origin.cafe.entity.Dish;
import com.origin.cafe.enums.DishType;

public class DishDTO {
	
	private Dish dish ;
	
	private String dishImg;
	
	private String dishName; 
	
	private int dishPrice;
	
	private String dishNote;
	
	private byte dishStatus;
	
	private int dishQuantity;
	
	private DishType dishType;

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public String getDishImg() {
		return dishImg;
	}

	public void setDishImg(String dishImg) {
		this.dishImg = dishImg;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	public String getDishNote() {
		return dishNote;
	}

	public void setDishNote(String dishNote) {
		this.dishNote = dishNote;
	}

	public byte getDishStatus() {
		return dishStatus;
	}

	public void setDishStatus(byte dishStatus) {
		this.dishStatus = dishStatus;
	}

	public int getDishQuantity() {
		return dishQuantity;
	}

	public void setDishQuantity(int dishQuantity) {
		this.dishQuantity = dishQuantity;
	}

	public DishType getDishType() {
		return dishType;
	}

	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}
	
	

}
