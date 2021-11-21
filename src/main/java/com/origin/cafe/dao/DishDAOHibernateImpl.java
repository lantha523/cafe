package com.origin.cafe.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.origin.cafe.entity.Dish;

@Repository  //该类是用来执行与数据库相关的操作（即dao对象）
public class DishDAOHibernateImpl implements DishDAO {
	
	//define field for entitymanager
	
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public DishDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	

	@Override
	public List<Dish> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Dish> theQuery = 
				currentSession.createQuery("from Dish",Dish.class);
		
		//execute query and get result list
		List <Dish> dishs = theQuery.getResultList();
		
		//return the results
		
		return dishs;
	}

	@Override
	public Dish findById(int theDishNo) {
		
		// get the current hiernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the Dish
		Dish theDish = 
				currentSession.get(Dish.class, theDishNo);
		
		//return the Dish
		return theDish;
	}

	@Override
	public void save(Dish theDish) {
		// get the current hiernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save dish
		currentSession.saveOrUpdate(theDish);
	}

	@Override
	public void deleteById(int theDishNo) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete dish with pk
		Query theQuery = 
				currentSession.createQuery("delete from Dish where id=:dishDishNo");
		theQuery.setParameter("dishDishNo", theDishNo);
		theQuery.executeUpdate();

	}

}
