package com.origin.cafe.entity;

import com.origin.cafe.enums.DishType;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name="dish")
public class Dish {
		
		//定義fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="dish_no")
		private int dishNo;
		
		@Column(name="dish_img")
		private String dishImg;
		
		@Column(name="dish_name")
		private String dishName;
		
		@Column(name="dish_price")
		private int dish_Price;
		
		@Column(name="dish_note")
		private String dishNote;
		
		@Column(name="dish_status")
		private byte dishStatus;
		
		@Column(name="dish_quantity")
		private int dishQuantity;
		
		@Column(name="cr_date")
		private Date crDate;
		
		@Column(name="md_date")
		private Date mdDate;
		
		@Column(name="dish_type")
		@Enumerated(EnumType.STRING)
		private DishType dishType;
		
		@OneToMany(mappedBy="dish" , cascade=CascadeType.ALL)
		private List<OrderList> orderLists;
	
		
		//定義contructors
		
		public Dish () {
		
		}


		public Dish(int dishNo, String dishImg, String dishName, int dish_Price, String dishNote, byte dishStatus, int dishQuantity, Date crDate,
				Date mdDate, DishType dishType, List<OrderList> orderLists) {
			this.dishNo = dishNo;
			this.dishImg = dishImg;
			this.dishName = dishName;
			this.dish_Price = dish_Price;
			this.dishNote = dishNote;
			this.dishStatus = dishStatus;
			this.dishQuantity = dishQuantity;
			this.crDate = crDate;
			this.mdDate = mdDate;
			this.dishType = dishType;
			this.orderLists = orderLists;
		}

		public int getDishNo() {
			return dishNo;
		}


		public void setDishNo(int dishNo) {
			this.dishNo = dishNo;
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


		public int getDish_Price() {
			return dish_Price;
		}


		public void setDish_Price(int dish_Price) {
			this.dish_Price = dish_Price;
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


		public DishType getDishType() {
			return dishType;
		}

		public void setDishType(DishType dishType) {
			this.dishType = dishType;
		}

		public List<OrderList> getOrderLists() {
			return orderLists;
		}

		public void setOrderLists(List<OrderList> orderLists) {
			this.orderLists = orderLists;
		}

		@Override
		public String toString() {
			return "Dish{" +
					"dishNo=" + dishNo +
					", dishImg='" + dishImg + '\'' +
					", dishName='" + dishName + '\'' +
					", dish_Price=" + dish_Price +
					", dishNote='" + dishNote + '\'' +
					", dishStatus=" + dishStatus +
					", dishQuantity=" + dishQuantity +
					", crDate=" + crDate +
					", mdDate=" + mdDate +
					", dishType=" + dishType +
					", orderLists=" + orderLists +
					'}';
		}
	}
