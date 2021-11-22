package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.AdmFunction;

public interface AdmFunctionService {
	
	public List<AdmFunction> findAll();
	
	public AdmFunction findById(int theFunctionNo);
	
	public void save(AdmFunction theAdmFunction);
	
	public void deleteById(int theFunctionNo);

}
