package com.origin.cafe.repository;

import com.origin.cafe.enums.Level;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.Administrator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{
	
  List<Administrator> findByAdmLevelOrderByAdmNoAsc(Level admLevel);

  @Query(value = "select * from administrator where adm_name like %:keyWord% or adm_address like %:keyWord% or adm_phone like %:keyWord%  order by adm_no asc", nativeQuery = true)
  List<Administrator> findByKeyword(@Param("keyWord") String keyWord);

  @Query(value = "select * from administrator where ( adm_name like %:keyWord% or adm_address like %:keyWord% or adm_phone like %:keyWord% ) and adm_level=:level order by adm_no asc", nativeQuery = true)
  List<Administrator> findByKeywordAndLevel(@Param("level") String admLevel, @Param("keyWord") String keyWord);
  //@Param 通過命名參數將方法參數綁定到查詢的註釋。

}

