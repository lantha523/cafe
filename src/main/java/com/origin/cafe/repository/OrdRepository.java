package com.origin.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.Ord;

public interface OrdRepository extends JpaRepository<Ord,Integer> {

}
