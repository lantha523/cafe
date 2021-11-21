package com.origin.cafe.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.origin.cafe.entity.Order;

@Repository  //该类是用来执行与数据库相关的操作（即dao对象）
public class OrderDAOHibernateImpl implements OrderDAO {
	
	//define field for Entitymanager 類似於JDBC的connection EntityManager主要在管理Entity實例生命週期 透過EntityManager，您對Entity實例的操作，可以對應至資料庫進行新增、查找、修改、刪除、重清等動作
	
	private EntityManager entityManager;
	
	//set up constructor injection  注入構造函數
	@Autowired
	public OrderDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Order> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Order> theQuery =
				currentSession.createQuery("from Order", Order.class);
		
		List<Order> orders = theQuery.getResultList();
		
		return orders;
	}

	@Override
	public Order findById(int theOrdNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Order theOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theOrdNo) {
		// TODO Auto-generated method stub

	}

}
