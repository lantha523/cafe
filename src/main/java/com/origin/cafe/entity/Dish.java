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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
		private int dishPrice;
		
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

	}