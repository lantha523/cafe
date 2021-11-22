package com.origin.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_list")
public class OrderList {

	// 定義fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_no")
	private int ordNo;

//	@Column(name = "DISH_NO")  欄位重複會出錯
//	private int dishNo;

	@Column(name = "ord_quantity")
	private int ordQuantity;

	@Column(name = "ord_priceeach")
	private int ordPriceEach;
	
	@ManyToOne
	@JoinColumn(name="dish_no")
	private Dish dish;
	
	public OrderList() {
		
	}

	public OrderList(int ordNo, int ordQuantity, int ordPriceEach, Dish dish) {
		super();
		this.ordNo = ordNo;
		this.ordQuantity = ordQuantity;
		this.ordPriceEach = ordPriceEach;
		this.dish = dish;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
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

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	@Override
	public String toString() {
		return "OrderList [ordNo=" + ordNo + ", ordQuantity=" + ordQuantity + ", ordPriceEach=" + ordPriceEach
				+ ", dish=" + dish + "]";
	}

	

	
	

}
