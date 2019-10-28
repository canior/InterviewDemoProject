package com.carriersedge.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carriersedge.demo.entity.UserCurriculum;

@Repository
public class UserCurriculumDAOImpl implements UserCurriculumDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	public void saveUserCurriculum(UserCurriculum userCurriculum) {
		sessionFactory.getCurrentSession().saveOrUpdate(userCurriculum);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCurriculum> getUserCurriculums(String username) {
		return sessionFactory.getCurrentSession()
				.createQuery("from UserCurriculum where username = :username")
				.setParameter("username", username)
				.list();
	}
}
