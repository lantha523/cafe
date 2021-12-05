package com.origin.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="dish_no")
	private Dish dish;

}
