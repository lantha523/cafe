package com.origin.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_function")
public class AdmFunction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "function_no")
	private int functionNo;

	@Column(name = "function_detail")
	private String functionDetail;
	
	
	public AdmFunction () {
		
	}


	public AdmFunction(int functionNo, String functionDetail) {
		super();
		this.functionNo = functionNo;
		this.functionDetail = functionDetail;
	}


	public int getFunctionNo() {
		return functionNo;
	}


	public void setFunctionNo(int functionNo) {
		this.functionNo = functionNo;
	}


	public String getFunctionDetail() {
		return functionDetail;
	}


	public void setFunctionDetail(String functionDetail) {
		this.functionDetail = functionDetail;
	}


	@Override
	public String toString() {
		return "AdmFunction [functionNo=" + functionNo + ", functionDetail=" + functionDetail + "]";
	}
	
	

}
