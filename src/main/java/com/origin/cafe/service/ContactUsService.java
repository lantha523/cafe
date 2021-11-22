package com.origin.cafe.service;

import java.util.List;

import com.origin.cafe.entity.ContactUs;

public interface ContactUsService {
	
	public List<ContactUs> findAll();
	
	public ContactUs findById(int theConNo);
	
	public void save(ContactUs theContactUs);
	
	public void deleteById(int theConNo);

}
