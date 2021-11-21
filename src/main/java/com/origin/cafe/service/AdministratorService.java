package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.Administrator;

public interface AdministratorService {
	
	public List<Administrator> findAll();
	
	public Administrator findById(int theAdmNo);
	
	public void save(Administrator theAdm);
	
	public void deleteById(int theAdmNo);
	
	

}
