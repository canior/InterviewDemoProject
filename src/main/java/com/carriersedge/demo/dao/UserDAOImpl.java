package com.carriersedge.demo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carriersedge.demo.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public User getAdminUser() {
		return (User)sessionFactory.getCurrentSession()
				.createQuery("from User where username=:name")
				.setParameter("name", "admin")
				.uniqueResult();
	}
	
	@Override
	public User getUserById(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

}
