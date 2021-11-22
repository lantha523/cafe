package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LIST")
public class OrderList {

	// 定義fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORD_NO")
	private int ordNo;

	@Column(name = "DISH_NO")
	private int dishNo;

	@Column(name = "ORD_QUANTITY")
	private int ordQuantity;

	@Column(name = "ORD_PRICEEACH")
	private int ordPriceEach;
	
	public OrderList() {
		
	}

	public OrderList(int ordNo, int dishNo, int ordQuantity, int ordPriceEach) {
		super();
		this.ordNo = ordNo;
		this.dishNo = dishNo;
		this.ordQuantity = ordQuantity;
		this.ordPriceEach = ordPriceEach;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public int getDishNo() {
		return dishNo;
	}

	public void setDishNo(int dishNo) {
		this.dishNo = dishNo;
	}

	public int getOrdQuantity() {
		return ordQuantity;
	}

	public void setOrdQuantity(int ordQuantity) {
		this.ordQuantity = ordQuantity;
	}

	public int getOrdPriceEach() {
		return ordPriceEach;
	}

	public void setOrdPriceEach(int ordPriceEach) {
		this.ordPriceEach = ordPriceEach;
	}

	@Override
	public String toString() {
		return "OrderList [ordNo=" + ordNo + ", dishNo=" + dishNo + ", ordQuantity=" + ordQuantity + ", ordPriceEach="
				+ ordPriceEach + "]";
	}
	
	

	
	

}
