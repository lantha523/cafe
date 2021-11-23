package com.origin.cafe.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	
	//定義fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mem_no")
	private int memNo;
	
	@Column(name="mem_name")
	private String memName;
	
	@Column(name="mem_phone")
	private String memPhone;
	
	@Column(name="mem_email")
	private String memEmail;
	
	@Column(name="mem_address")
	private String memAddress;
	
	@Column(name="mem_birth")
	private Date memBirth;
	
	@Column(name="mem_img")
	private String memImg;
	
	@Column(name="mem_status")
	private byte memStatus;
	
	@Column(name="cr_date")
	private Date crDate;
	
	@Column(name="md_date")
	private Date mdDate;
	
	@OneToMany(mappedBy="member" , cascade=CascadeType.ALL)
	private List<Ord> ords;
	
	//定義contructors
	
	public Member () {
	
	}


	public Member(int memNo, String memName, String memPhone, String memEmail,
			String memAddress, Date memBirth, String memImg, byte memStatus, Date crDate, Date mdDate) {
		super();
		this.memNo = memNo;
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
		return "Member{" +
				"memNo=" + memNo +
				", memName='" + memName + '\'' +
				", memPhone='" + memPhone + '\'' +
				", memEmail='" + memEmail + '\'' +
				", memAddress='" + memAddress + '\'' +
				", memBirth=" + memBirth +
				", memImg='" + memImg + '\'' +
				", memStatus=" + memStatus +
				", crDate=" + crDate +
				", mdDate=" + mdDate +
				", ords=" + ords +
				'}';
	}
}
