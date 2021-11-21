package com.origin.cafe.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.origin.cafe.entity.Member;

@Repository  //该类是用来执行与数据库相关的操作（即dao对象）
public class MemberDAOHibernateImpl implements MemberDao {

	
	//define field for Entitymanager 類似於JDBC的connection EntityManager主要在管理Entity實例生命週期 透過EntityManager，您對Entity實例的操作，可以對應至資料庫進行新增、查找、修改、刪除、重清等動作
	
	private EntityManager entityManager;
	
	//set up constructor injection  注入構造函數
	@Autowired
	public MemberDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Member> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
	    Query<Member> theQuery = 
			currentSession.createQuery("from Member",Member.class);
	    
	 	//execute query and get result list
		List<Member> members = theQuery.getResultList();
	
		//return the results

		return members;
	}
	@Override
	public Member findById(int theMemNo) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get tje member
		Member theMember = 
				currentSession.get(Member.class, theMemNo);
		
		//return the member
		return theMember;

	}
	@Override
	public void save(Member theMember) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//save member
		currentSession.saveOrUpdate(theMember);
		
	}
	@Override
	public void deleteById(int theMemNo) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete member with PK
		Query theQuery = 
				currentSession.createQuery("delete from Member where id=:memberMemNo");
		theQuery.setParameter("memberMemNo", theMemNo);
		theQuery.executeUpdate();
		
	}

	
	

}
