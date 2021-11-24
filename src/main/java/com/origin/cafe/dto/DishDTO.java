package com.origin.cafe.dto;

import java.sql.Date;

import com.origin.cafe.enums.DishType;

public class DishDTO {
	
	private int dishNo;
	
	private String dishName; 
	
	private DishType dishType;
	
	private int dishPrice;
	
	private int dishQuantity;
	
	private byte dishStatus;
	
	private String dishImg;
	
	private Date crDate;
	
	private Date mdDate;
	
	
	

	public String getDishImg() {
		return dishImg;
	}

	public void setDishImg(String dishImg) {
		this.dishImg = dishImg;
	}

	public Date getCrDate() {
		return crDate;
	}

	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

	public Date getMdDate() {
		return mdDate;
	}

	public void setMdDate(Date mdDate) {
		this.mdDate = mdDate;
	}

	public int getDishNo() {
		return dishNo;
	}

	public void setDishNo(int dishNo) {
		this.dishNo = dishNo;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public DishType getDishType() {
		return dishType;
	}

	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	public int getDishQuantity() {
		return dishQuantity;
	}

	public void setDishQuantity(int dishQuantity) {
		this.dishQuantity = dishQuantity;
	}

	public byte getDishStatus() {
		return dishStatus;
	}

	public void setDishStatus(byte dishStatus) {
		this.dishStatus = dishStatus;
	}

	@Override
	public String toString() {
		return "DishDTO [dishNo=" + dishNo + ", dishName=" + dishName + ", dishType=" + dishType + ", dishPrice="
				+ dishPrice + ", dishQuantity=" + dishQuantity + ", dishStatus=" + dishStatus + ", dishImg=" + dishImg
				+ ", crDate=" + crDate + ", mdDate=" + mdDate + "]";
	}


	

	

}
