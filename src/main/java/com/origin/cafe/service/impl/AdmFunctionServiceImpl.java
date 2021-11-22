package com.origin.cafe.service.impl;

import com.origin.cafe.service.AdmFunctionService;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.origin.cafe.entity.AdmFunction;
import com.origin.cafe.repository.AdmFunctionRepository;

@Service
public class AdmFunctionServiceImpl implements AdmFunctionService {
	
	private AdmFunctionRepository admFunctionRepository;
	
	public AdmFunctionServiceImpl(AdmFunctionRepository theAdmFunctionRepository) {
		admFunctionRepository = theAdmFunctionRepository;
	}

	@Override
	public List<AdmFunction> findAll() {
		// TODO Auto-generated method stub
		return admFunctionRepository.findAll();
	}

	@Override
	public AdmFunction findById(int theFunctionNo) {
		Optional<AdmFunction> result = admFunctionRepository.findById(theFunctionNo);
		
		AdmFunction theAdmFunction = null;
		
		if (result.isPresent()) {
			theAdmFunction = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theFunctionNo);
		}
		
		return theAdmFunction;
	}

	@Override
	public void save(AdmFunction theAdmFunction) {
		admFunctionRepository.save(theAdmFunction);

	}

	@Override
	public void deleteById(int theFunctionNo) {
		admFunctionRepository.deleteById(theFunctionNo);

	}

}
