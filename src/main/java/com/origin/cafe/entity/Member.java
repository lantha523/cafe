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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
