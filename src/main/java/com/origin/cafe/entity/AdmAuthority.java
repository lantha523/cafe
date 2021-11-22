package com.origin.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="adm_authority")
public class AdmAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adm_authority_no")
	private int admAuthorityNo;
	
	@ManyToOne
	@JoinColumn(name="adm_no")
	private Administrator administrator;
	
	@ManyToOne
	@JoinColumn(name="function_no")
	private AdmFunction admFunction;
	
	public AdmAuthority() {
		
	}

	public AdmAuthority(int admAuthorityNo, Administrator administrator, AdmFunction admFunction) {
		super();
		this.admAuthorityNo = admAuthorityNo;
		this.administrator = administrator;
		this.admFunction = admFunction;
	}

	public int getAdmAuthorityNo() {
		return admAuthorityNo;
	}

	public void setAdmAuthorityNo(int admAuthorityNo) {
		this.admAuthorityNo = admAuthorityNo;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public AdmFunction getAdmFunction() {
		return admFunction;
	}

	public void setAdmFunction(AdmFunction admFunction) {
		this.admFunction = admFunction;
	}

	@Override
	public String toString() {
		return "AdmAuthority [admAuthorityNo=" + admAuthorityNo + ", administrator=" + administrator + ", admFunction="
				+ admFunction + "]";
	}
	
	


}
