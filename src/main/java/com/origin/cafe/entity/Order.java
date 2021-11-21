package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER")
public class Order {

	// 定義fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORD_NO")
	private int ordNo;

	@Column(name = "MEM_NO")
	private int memNo;

	@Column(name = "ORD_TIME")
	private Date ordTime;

	@Column(name = "ORD_PRICE")
	private int ordPrice;

	@Column(name = "ORD_STATUS")
	private byte ordStatus;

	@Column(name = "CR_DATE")
	private Date crDate;
	
	@Column(name = "MD_DATE")
	private Date mdDate;
	
	@ManyToOne
	@JoinColumn(name="MEM_NO")
	private Member member;

	// 定義contructor

	public Order() {

	}


	public Order(int ordNo, int memNo, Date ordTime, int ordPrice, byte ordStatus, Date crDate, Date mdDate) {
		super();
		this.ordNo = ordNo;
		this.memNo = memNo;
		this.ordTime = ordTime;
		this.ordPrice = ordPrice;
		this.ordStatus = ordStatus;
		this.crDate = crDate;
		this.mdDate = mdDate;
	}


	public int getOrdNo() {
		return ordNo;
	}


	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public Date getOrdTime() {
		return ordTime;
	}


	public void setOrdTime(Date ordTime) {
		this.ordTime = ordTime;
	}


	public int getOrdPrice() {
		return ordPrice;
	}


	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}


	public byte getOrdStatus() {
		return ordStatus;
	}


	public void setOrdStatus(byte ordStatus) {
		this.ordStatus = ordStatus;
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
		return "Order [ordNo=" + ordNo + ", memNo=" + memNo + ", ordTime=" + ordTime + ", ordPrice=" + ordPrice
				+ ", ordStatus=" + ordStatus + ", crDate=" + crDate + ", mdDate=" + mdDate + "]";
	}
	
	

}
