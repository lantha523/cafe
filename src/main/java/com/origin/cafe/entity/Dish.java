package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="DISH")
public class Dish {
		
		//定義fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="DISH_NO")
		private int dishNo;
		
		@Column(name="DISH_IMG")
		private String dishImg;
		
		@Column(name="DISH_NAME")
		private String dishName;
		
		@Column(name="DISH_PRICE")
		private int dish_Price;
		
		@Column(name="DISH_NOTE")
		private String dishNote;
		
		@Column(name="DISH_STATUS")
		private byte dishStatus;
		
		@Column(name="DISH_QUANTITY")
		private int dishQuantity;
		
		@Column(name="CR_DATE")
		private Date crDate;
		
		@Column(name="MD_DATE")
		private Date mdDate;
		
		@Column(name="DISH_TYPE")
		private String dishType;
		
		
		//定義contructors
		
		public Dish () {
		
		}


		public Dish(int dishNo, String dishImg, String dishName, int dish_Price, String dishNote, byte dishStatus,
				int dishQuantity, Date crDate, Date mdDate, String dishType) {
			super();
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


		public String getDishType() {
			return dishType;
		}


		public void setDishType(String dishType) {
			this.dishType = dishType;
		}


		@Override
		public String toString() {
			return "Dish [dishNo=" + dishNo + ", dishImg=" + dishImg + ", dishName=" + dishName + ", dish_Price="
					+ dish_Price + ", dishNote=" + dishNote + ", dishStatus=" + dishStatus + ", dishQuantity="
					+ dishQuantity + ", crDate=" + crDate + ", mdDate=" + mdDate + ", dishType=" + dishType + "]";
		}
		
		
		

		



	

}
