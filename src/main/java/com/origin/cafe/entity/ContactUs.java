package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_us")
public class ContactUs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="con_no")
	private int conNo;
	
	@Column(name="con_name")
	private String conName;
	
	@Column(name="con_email")
	private String conEmail;
	
	@Column(name="con_phone")
	private String conPhone;
	
	@Column(name="con_msg")
	private String conMsg;
	
	@Column(name="con_time")
	private Date conTime;
	
	
	public ContactUs() {
		
	}

	public ContactUs(int conNo, String conName, String conEmail, String conPhone, String conMsg, Date conTime) {
		super();
		this.conNo = conNo;
		this.conName = conName;
		this.conEmail = conEmail;
		this.conPhone = conPhone;
		this.conMsg = conMsg;
		this.conTime = conTime;
	}

	public int getConNo() {
		return conNo;
	}

	public void setConNo(int conNo) {
		this.conNo = conNo;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConEmail() {
		return conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public String getConPhone() {
		return conPhone;
	}

	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}

	public String getConMsg() {
		return conMsg;
	}

	public void setConMsg(String conMsg) {
		this.conMsg = conMsg;
	}

	public Date getConTime() {
		return conTime;
	}

	public void setConTime(Date conTime) {
		this.conTime = conTime;
	}

	@Override
	public String toString() {
		return "ContactUs [conNo=" + conNo + ", conName=" + conName + ", conEmail=" + conEmail + ", conPhone="
				+ conPhone + ", conMsg=" + conMsg + ", conTime=" + conTime + "]";
	}
	
	


}
