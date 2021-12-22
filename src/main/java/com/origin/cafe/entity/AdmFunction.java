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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adm_function")
public class AdmFunction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "function_no")
	private int functionNo;

	@Column(name = "function_detail")
	private String functionDetail;


	@OneToMany(mappedBy="admFunction" , cascade=CascadeType.ALL)
	private List<AdmAuthority> admAuthoritys;


}
