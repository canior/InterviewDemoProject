package com.carriersedge.demo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carriersedge.demo.entity.Curriculum;

@Repository
public class CurriculumDAOImpl implements CurriculumDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public void saveCurriculum(Curriculum curriculum) {
		sessionFactory.getCurrentSession().saveOrUpdate(curriculum);
	}


	@Override
	public Curriculum getCurriculum(String name) {
		return (Curriculum) sessionFactory.getCurrentSession().createQuery("from Curriculum where name=:name")
				.setParameter("name", name).uniqueResult();
	}


	@Override
	public Curriculum getCurriculumById(long id) {
		return sessionFactory.getCurrentSession().get(Curriculum.class, id);
	}

}
