package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	
	//定義fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEM_NO")
	private int memNo;
	
	@Column(name="MEM_USERNAME")
	private String memUserName;
	
	@Column(name="MEM_PASSWORD")
	private String memPassword;
	
	@Column(name="MEM_NAME")
	private String memName;
	
	@Column(name="MEM_PHONE")
	private String memPhone;
	
	@Column(name="MEM_EMAIL")
	private String memEmail;
	
	@Column(name="MEM_ADDRESS")
	private String memAddress;
	
	@Column(name="MEM_BIRTH")
	private Date memBirth;
	
	@Column(name="MEM_IMG")
	private String memImg;
	
	@Column(name="MEM_STATUS")
	private byte memStatus;
	
	@Column(name="CR_DATE")
	private Date crDate;
	
	@Column(name="MD_DATE")
	private Date mdDate;
	
//	@OneToMany
//	@JoinColumn(name="member")
//	private List<Order> orders;
	
	//定義contructors
	
	public Member () {
	
	}


	public Member(int memNo, String memUserName, String memPassword, String memName, String memPhone, String memEmail,
			String memAddress, Date memBirth, String memImg, byte memStatus, Date crDate, Date mdDate) {
		super();
		this.memNo = memNo;
		this.memUserName = memUserName;
		this.memPassword = memPassword;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memAddress = memAddress;
		this.memBirth = memBirth;
		this.memImg = memImg;
		this.memStatus = memStatus;
		this.crDate = crDate;
		this.mdDate = mdDate;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getMemUserName() {
		return memUserName;
	}


	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}


	public String getMemPassword() {
		return memPassword;
	}


	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getMemPhone() {
		return memPhone;
	}


	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}


	public String getMemEmail() {
		return memEmail;
	}


	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}


	public String getMemAddress() {
		return memAddress;
	}


	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}


	public Date getMemBirth() {
		return memBirth;
	}


	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}


	public String getMemImg() {
		return memImg;
	}


	public void setMemImg(String memImg) {
		this.memImg = memImg;
	}


	public byte getMemStatus() {
		return memStatus;
	}


	public void setMemStatus(byte memStatus) {
		this.memStatus = memStatus;
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


	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memUserName=" + memUserName + ", memPassword=" + memPassword + ", memName="
				+ memName + ", memPhone=" + memPhone + ", memEmail=" + memEmail + ", memAddress=" + memAddress
				+ ", memBirth=" + memBirth + ", memImg=" + memImg + ", memStatus=" + memStatus + ", crDate=" + crDate
				+ ", mdDate=" + mdDate + "]";
	}
	
	
	
	
	

}
