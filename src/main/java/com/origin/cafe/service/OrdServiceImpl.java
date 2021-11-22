package com.origin.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.origin.cafe.entity.Ord;
import com.origin.cafe.repository.OrdRepository;

@Service
public class OrdServiceImpl implements OrdService {
	
	private OrdRepository ordRepository;
	
	@Autowired
	public OrdServiceImpl(OrdRepository theOrdRepository) {
		ordRepository = theOrdRepository;
		
	}

	@Override
	@Transactional
	public List<Ord> findAll() {
		return ordRepository.findAll();
	}

	@Override
	public Ord findById(int theOrdNo) {
		Optional<Ord> result = ordRepository.findById(theOrdNo);
		
		Ord theOrd = null;
		
		if (result.isPresent()) {
			theOrd = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find ORD id - " + theOrdNo);
		}
		
		return theOrd;

	}

	@Override
	public void save(Ord theOrd) {
		
		ordRepository.save(theOrd);

	}

	@Override
	public void deleteById(int theOrdNo) {
		
		ordRepository.deleteById(theOrdNo);

	}

}
