package com.origin.cafe.service.impl;

import com.origin.cafe.service.ContactUsService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.origin.cafe.entity.ContactUs;
import com.origin.cafe.repository.ContactUsRespository;

@Service
public class ContactUsServiceImpl implements ContactUsService {
	
	private ContactUsRespository contactUsRespository;
	
	@Autowired
	public ContactUsServiceImpl(ContactUsRespository theContactUsRespository) {
		contactUsRespository = theContactUsRespository;
		
	}
	

	@Override
	public List<ContactUs> findAll() {
		// TODO Auto-generated method stub
		return contactUsRespository.findAll();
	}

	@Override
	public ContactUs findById(int theConNo) {
		Optional<ContactUs> result = contactUsRespository.findById(theConNo);
		
		ContactUs theContactUs = null;
		
		if (result.isPresent()) {
			theContactUs = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find contactUs id - " + theConNo);
		}
		
		return theContactUs;
	}

	@Override
	public void save(ContactUs theContactUs) {
		contactUsRespository.save(theContactUs);

	}

	@Override
	public void deleteById(int theConNo) {
		contactUsRespository.deleteById(theConNo);

	}

}
