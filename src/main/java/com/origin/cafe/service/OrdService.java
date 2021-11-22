package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.Ord;

public interface OrdService {
	
	public List<Ord> findAll();
	
	public Ord findById(int theOrdNo);
	
	public void save(Ord theOrd);
	
	public void deleteById(int theOrdNo);

}
