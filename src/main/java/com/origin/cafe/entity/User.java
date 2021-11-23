package com.origin.cafe.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the users database table.
 * 會員帳密
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
	private static final long serialVersionUID = 1L;

	//會員帳號
	@Id
	@Column(name="username")
	private String username;

	//會員密碼
	@Column(name="password")
	private String password;

	//會員資格
	@Column(name="enabled")
	private Byte enabled;

	@ManyToOne
	@JoinColumn(name="mem_no")
	private Member member;

	@ManyToOne
	@JoinColumn(name="adm_no")
	private Administrator administrator;

	public User() {
	}

	public User(String username, String password, byte enabled, Member member, Administrator administrator) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.member = member;
		this.administrator = administrator;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getEnabled() {
		return enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", member=" + member +
				", administrator=" + administrator +
				'}';
	}
}