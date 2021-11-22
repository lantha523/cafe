package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_US")
public class ContactUs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CON_NO")
	private int conNo;
	
	@Column(name="CON_NAME")
	private String conName;
	
	@Column(name="CON_EMAIL")
	private String conEmail;
	
	@Column(name="CON_PHONE")
	private String conPhone;
	
	@Column(name="CON_MSG")
	private String conMsg;
	
	@Column(name="CON_TIME")
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
