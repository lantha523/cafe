package com.origin.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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



}
