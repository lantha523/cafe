package com.origin.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.OrderList;

public interface OrderListRespository  extends JpaRepository<OrderList, Integer> {

}
