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
@Table(name = "ord")
public class Ord {

	// 定義fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_no")
	private int ordNo;

//	@Column(name = "MEM_NO") 欄位重複會出錯
//	private int memNo;

	@Column(name = "ord_time")
	private Date ordTime;

	@Column(name = "ord_price")
	private int ordPrice;

	@Column(name = "ord_status")
	private byte ordStatus;

	@Column(name = "cr_date")
	private Date crDate;
	
	@Column(name = "md_date")
	private Date mdDate;
	
	@ManyToOne
	@JoinColumn(name="mem_no")
	private Member member;

	// 定義contructor

	public Ord() {

	}

	public Ord(int ordNo, Date ordTime, int ordPrice, byte ordStatus, Date crDate, Date mdDate, Member member) {
		super();
		this.ordNo = ordNo;
		this.ordTime = ordTime;
		this.ordPrice = ordPrice;
		this.ordStatus = ordStatus;
		this.crDate = crDate;
		this.mdDate = mdDate;
		this.member = member;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Ord [ordNo=" + ordNo + ", ordTime=" + ordTime + ", ordPrice=" + ordPrice + ", ordStatus=" + ordStatus
				+ ", crDate=" + crDate + ", mdDate=" + mdDate + ", member=" + member + "]";
	}

	

	
	
	

}
