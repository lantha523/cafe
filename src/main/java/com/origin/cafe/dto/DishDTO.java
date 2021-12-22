package com.origin.cafe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.origin.cafe.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
	
	
	private int dishNo;
	
	private String dishName; 
	
	private DishType dishType;
	
	private int dishPrice;
	
	private int dishQuantity;
	
	private String dishStatus;
	
	private String dishImg;
	
	private String crDate;
	
	private String mdDate;
	
	private String dishNote;
	


}
