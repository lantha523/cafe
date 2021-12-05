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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="mem_no")
	private Member member;

}
