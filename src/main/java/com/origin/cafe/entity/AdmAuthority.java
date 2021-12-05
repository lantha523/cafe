package com.origin.cafe.entity;

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
@Table(name="adm_authority")
public class AdmAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adm_authority_no")
	private int admAuthorityNo;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="adm_no")
	private Administrator administrator;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="function_no")
	private AdmFunction admFunction;

}
