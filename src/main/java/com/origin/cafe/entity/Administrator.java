package com.origin.cafe.entity;

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
@Table(name="administrator")
public class Administrator {
	
	//定義fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="adm_no")
		private int admNo;

		@Column(name="adm_name")
		private String admName;
		
		@Column(name="adm_address")
		private String admAddress;
		
		@Column(name="adm_phone")
		private String admPhone;
		
		@Column(name="adm_level")
		private String admLevel;
		
		@Column(name="adm_status")
		private byte admStatus;
		
		@OneToMany(mappedBy="administrator" , cascade=CascadeType.ALL)
		private List<AdmAuthority> admAuthoritys;
		
	public Administrator() {
		
	}

	public Administrator(int admNo, String admName, String admAddress, String admPhone, String admLevel, byte admStatus,
			List<AdmAuthority> admAuthoritys) {
		this.admNo = admNo;
		this.admName = admName;
		this.admAddress = admAddress;
		this.admPhone = admPhone;
		this.admLevel = admLevel;
		this.admStatus = admStatus;
		this.admAuthoritys = admAuthoritys;
	}

	public int getAdmNo() {
		return admNo;
	}

	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmAddress() {
		return admAddress;
	}

	public void setAdmAddress(String admAddress) {
		this.admAddress = admAddress;
	}

	public String getAdmPhone() {
		return admPhone;
	}

	public void setAdmPhone(String admPhone) {
		this.admPhone = admPhone;
	}

	public String getAdmLevel() {
		return admLevel;
	}

	public void setAdmLevel(String admLevel) {
		this.admLevel = admLevel;
	}

	public byte getAdmStatus() {
		return admStatus;
	}

	public void setAdmStatus(byte admStatus) {
		this.admStatus = admStatus;
	}

	@Override
	public String toString() {
		return "Administrator{" +
				"admNo=" + admNo +
				", admName='" + admName + '\'' +
				", admAddress='" + admAddress + '\'' +
				", admPhone='" + admPhone + '\'' +
				", admLevel='" + admLevel + '\'' +
				", admStatus=" + admStatus +
				", admAuthoritys=" + admAuthoritys +
				'}';
	}
}
