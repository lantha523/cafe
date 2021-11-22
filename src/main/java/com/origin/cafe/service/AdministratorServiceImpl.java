package com.origin.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.origin.cafe.entity.Administrator;
import com.origin.cafe.repository.AdministratorRepository;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	private AdministratorRepository administratorRepository;
	
	@Autowired //使用@Autowired注入dao的實例
	public AdministratorServiceImpl(AdministratorRepository theAdministratorRepository) {
		administratorRepository = theAdministratorRepository;
	}
	
	@Override
	public List<Administrator> findAll() {
		// TODO Auto-generated method stub
		return administratorRepository.findAll();
	}

	@Override
	public Administrator findById(int theAdmNo) {
		// 圈選 administratorRepository.findById(theAdmNo);右鍵refactor-->extrack local variable重構成result 
		Optional<Administrator> result = administratorRepository.findById(theAdmNo);
		
		Administrator theAdministrator = null;
		
		if (result.isPresent()) {
			theAdministrator = result.get();
		}else {
			throw new RuntimeException("Did not find emp Id-" + theAdmNo);
		}
		return theAdministrator;
	}

	@Override
	public void save(Administrator theAdm) {
		administratorRepository.save(theAdm);

	}

	@Override
	public void deleteById(int theAdmNo) {
		administratorRepository.deleteById(theAdmNo);

	}

}
