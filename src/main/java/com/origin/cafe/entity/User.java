package com.origin.cafe.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * The persistent class for the users database table.
 * 會員帳密
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	@OneToOne(cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="mem_no")
	private Member member;

	@OneToOne(cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="adm_no")
	private Administrator administrator;

}