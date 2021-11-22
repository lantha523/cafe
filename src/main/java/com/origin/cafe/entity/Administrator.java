package com.origin.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminstrator")
public class Administrator {
	
	//定義fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ADM_NO")
		private int admNo;
		
		@Column(name="ADM_ACCOUNT")
		private String admAccount;
		
		@Column(name="ADM_PASWORD")
		private String admPasword;
		
		@Column(name="ADM_NAME")
		private String admName;
		
		@Column(name="ADM_ADDRESS")
		private String admAddress;
		
		@Column(name="ADM_PHONE")
		private String admPhone;
		
		@Column(name="ADM_LEVEL")
		private String admLevel;
		
		@Column(name="ADM_STATUS")
		private byte admStatus;
		
	public Administrator() {
		
	}

	public Administrator(int admNo, String admAccount, String admPasword, String admName, String admAddress,
			String admPhone, String admLevel, byte admStatus) {
		super();
		this.admNo = admNo;
		this.admAccount = admAccount;
		this.admPasword = admPasword;
		this.admName = admName;
		this.admAddress = admAddress;
		this.admPhone = admPhone;
		this.admLevel = admLevel;
		this.admStatus = admStatus;
	}

	public int getAdmNo() {
		return admNo;
	}

	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}

	public String getAdmAccount() {
		return admAccount;
	}

	public void setAdmAccount(String admAccount) {
		this.admAccount = admAccount;
	}

	public String getAdmPasword() {
		return admPasword;
	}

	public void setAdmPasword(String admPasword) {
		this.admPasword = admPasword;
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
		return "Administrator [admNo=" + admNo + ", admAccount=" + admAccount + ", admPasword=" + admPasword
				+ ", admName=" + admName + ", admAddress=" + admAddress + ", admPhone=" + admPhone + ", admLevel="
				+ admLevel + ", admStatus=" + admStatus + "]";
	}
	
	
	

}
