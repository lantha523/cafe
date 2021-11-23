package com.origin.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{
	
//	public List<Administrator> findAllByOrderByAdmAccountAsc();

}

